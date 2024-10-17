package ra.api.categy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.categy.dto.response.ResponseDto;
import ra.api.categy.entity.Account;
import ra.api.categy.service.acount.IServiceAcount;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IServiceAcount iServiceAcount;


    @GetMapping
    public ResponseEntity<ResponseDto> getAllAccount() {
        List<Account> list = iServiceAcount.findAll();
        return new ResponseEntity<>(new ResponseDto(list, HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getAccountById(@PathVariable Long id) {
        Account account1 = iServiceAcount.findById(id);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(new ResponseDto(account1, HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account account1 = iServiceAcount.findById(id);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account1.setId(account.getId());
        account1.setFullName(account.getFullName());
        account1.setPassword(account.getPassword());
        account1.setStatus(account.isStatus());

        return new ResponseEntity<>(new ResponseDto(account1, HttpStatus.CREATED, HttpStatus.CREATED.value()), HttpStatus.CREATED);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteAccount(@PathVariable Long id) {
        Account account1 = iServiceAcount.findById(id);
        if (account1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iServiceAcount.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
