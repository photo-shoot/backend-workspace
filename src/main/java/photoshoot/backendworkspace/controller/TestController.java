package photoshoot.backendworkspace.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photoshoot.backendworkspace.dto.test.TestAdminDTO;
import photoshoot.backendworkspace.dto.test.TestMemberDTO;
import photoshoot.backendworkspace.dto.test.TestPhotographerDTO;
import photoshoot.backendworkspace.dto.test.TestStudioDTO;
import photoshoot.backendworkspace.service.*;

import java.util.List;

@Tag(name="Test api")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @JsonIgnore
    @Operation(summary = "MEMBER 리스트 출력", description = "MEMBER 타입인 회원들만 리스트 출력!")
    @GetMapping("/member/all")
    public ResponseEntity<?> memberAll(){
        List<TestMemberDTO> memberList = testService.memberAll();
        return ResponseEntity.ok().body(memberList);
    }

    @JsonIgnore
    @GetMapping("/admin/all")
    public ResponseEntity<?> adminAll(){
        List<TestAdminDTO> adminList = testService.adminAll();
        return ResponseEntity.ok().body(adminList);
    }

    @GetMapping("/studio/all")
    public ResponseEntity<?> studioAll(){
        List<TestStudioDTO> studioList = testService.studioAll();
        return ResponseEntity.ok().body(studioList);
    }

    @GetMapping("/photographer/all")
    public ResponseEntity<?> photographerAll(){
        List<TestPhotographerDTO> photographerList = testService.photographerAll();
        return ResponseEntity.ok().body(photographerList);
    }

}
