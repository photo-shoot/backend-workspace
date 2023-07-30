package photoshoot.backendworkspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import photoshoot.backendworkspace.dto.signup.SignupRequestDTO;
import photoshoot.backendworkspace.service.SignService;

@Slf4j
@RestController
public class SignController {

    @Autowired
    SignService signService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDTO dto){
        return signService.signup(dto);
    }

}
