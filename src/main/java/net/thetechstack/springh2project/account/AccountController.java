package net.thetechstack.springh2project.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountRepository accountRepository;
    @GetMapping("/{number}")
    public ResponseEntity<Account> get(@PathVariable("number") String number){
        return accountRepository.findById(number)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Account> post(@RequestBody Account account) {
        account.setNumber(UUID.randomUUID().toString());
        return ResponseEntity.ok(accountRepository.save(account));
    }
}
