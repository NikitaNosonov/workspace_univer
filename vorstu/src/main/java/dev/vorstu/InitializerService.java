package dev.vorstu;

import dev.vorstu.dto.*;
import dev.vorstu.dto.credential.Credential;
import dev.vorstu.dto.credential.Role;
import dev.vorstu.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class InitializerService {
    @Lazy
    @Autowired
    private final CredentialService credentialService;
    @Lazy
    @Autowired
    private final UserService userService;
    @Lazy
    @Autowired
    private final BusinessPersonService businessPersonService;
    @Lazy
    @Autowired
    private final LocationService locationService;
    @Lazy
    @Autowired
    private final PowerBankService powerBankService;
    @Lazy
    @Autowired
    private final PhotoService photoService;
    @Lazy
    @Autowired
    private final RentalService rentalService;

    public void initial() {
        Credential credential = credentialService.create(Credential.builder()
                .username("user")
                .password("1111")
                .role(Role.USER)
                .build());

        Credential credential1 = credentialService.create(Credential.builder()
                .username("admin")
                .password("1111")
                .role(Role.ADMIN)
                .build());

        Credential credential2 = credentialService.create(Credential.builder()
                .username("user1")
                .password("1111")
                .role(Role.USER)
                .build());

        User adminId = userService.create(User.builder()
                .fio("Админ Админович")
                .credentialId(credential1.getId())
                .build());

        User userId = userService.create(User.builder()
                .fio("Иванов Иван Иванович")
                .email("i1@mail.ru")
                .phoneNumber("11122233377")
                .credentialId(credential.getId())
                .build());

        User userId1 = userService.create(User.builder()
                .fio("Алексеев Алекей Алексеевич")
                .email("a1@mail.ru")
                .phoneNumber("84732744447")
                .credentialId(credential2.getId())
                .build());

        BusinessPerson businessPersonId1 = businessPersonService.create(BusinessPerson.builder()
                .nameBusiness("ИП ААА")
                .applicationId(Long.valueOf(21213))
                .userId(userId.getId())
                .approvedApplication(true)
                .build());

        Location locationId = locationService.create(Location.builder()
                .nameLocation("Отель Алекс")
                .description("Отель Алексеева Алексея")
                .businessPersonId(businessPersonId1.getId())
                .latitude(51.662356)
                .longitude(39.198158)
                .build());

        Location locationId1 = locationService.create(Location.builder()
                .nameLocation("Отель")
                .description("Отель Алексеева")
                .businessPersonId(businessPersonId1.getId())
                .latitude(51.661563)
                .longitude(39.132985)
                .build());

        PowerBank powerBankId1 = powerBankService.create(PowerBank.builder()
                .type("Мощный")
                .capacity(10000)
                .charge(100)
                .statusPowerBank(true)
                .ownerLocationId(locationId.getId())
                .locationPowerBankId(locationId.getId())
                .build());

        PowerBank powerBankId2 = powerBankService.create(PowerBank.builder()
                .type("Маломощный")
                .capacity(7000)
                .charge(100)
                .statusPowerBank(true)
                .ownerLocationId(locationId.getId())
                .locationPowerBankId(locationId.getId())
                .build());



        Rental rentalId1 = rentalService.create(Rental.builder()
                .startTime(Timestamp.valueOf("2025-01-14 12:00:00"))
                .endTime(Timestamp.valueOf("2025-01-14 18:00:00"))
                .userId(userId.getId())
                .powerBankId(powerBankId1.getId())
                .build());

        Rental rentalId2 = rentalService.create(Rental.builder()
                .startTime(Timestamp.valueOf("2025-01-14 07:00:00"))
                .endTime(Timestamp.valueOf("2025-01-14 09:00:00"))
                .userId(userId1.getId())
                .build());
    }
}
