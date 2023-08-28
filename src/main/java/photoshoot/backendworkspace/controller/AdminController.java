package photoshoot.backendworkspace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import photoshoot.backendworkspace.dto.photographer.create.request.CreatePhotographerRequestToTalDTO;
import photoshoot.backendworkspace.dto.photographer.create.response.CreatePhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.select.AdminSelectPhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.select.SelectPhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.update.UpdatePhotographerRequestDTO;
import photoshoot.backendworkspace.dto.studio.create.request.CreateStudioRequestToTalDTO;
import photoshoot.backendworkspace.dto.studio.create.response.CreateStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.select.AdminSelectStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.select.SelectStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.update.UpdateStudioRequestDTO;
import photoshoot.backendworkspace.entity.Studio;
import photoshoot.backendworkspace.service.AdminService;

import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/admin")
@Tag(name="Admin api")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Operation(summary = "사진관 생성", description = "ADMIN 회원의 사진관 생성 api입니다.")
    @PostMapping("/studio")
    public ResponseEntity<CreateStudioResponseDTO> createStudio(@RequestBody CreateStudioRequestToTalDTO dto){
        CreateStudioResponseDTO savedStudio = adminService.createStudio(dto);
        return ResponseEntity.created(URI.create("/studio/" + savedStudio.getStoreId())).body(savedStudio);
    }

    @Operation(summary = "사진관 조회", description = "ADMIN 회원의 사진관 조회 api입니다.")
    @GetMapping("/studio/{storeId}")
    public ResponseEntity<AdminSelectStudioResponseDTO> selectStudio(@PathVariable(name = "storeId") Long storeId){
        AdminSelectStudioResponseDTO selectedStudio = adminService.selectStudio(storeId);
        return ResponseEntity.ok().body(selectedStudio);
    }

    @Operation(summary = "사진관 수정", description = "ADMIN 회원의 사진관 수정 api입니다.")
    @PatchMapping("/studio/{storeId}")
    public ResponseEntity<AdminSelectStudioResponseDTO> updateStudio(@RequestBody UpdateStudioRequestDTO changedDTO, @PathVariable(name = "storeId") Long storeId){
        AdminSelectStudioResponseDTO updatedStudio = adminService.updateStudio(changedDTO, storeId);
        return ResponseEntity.ok().body(updatedStudio);
    }

    @Operation(summary = "사진관 삭제", description = "ADMIN 회원의 사진관 삭제 api입니다.")
    @DeleteMapping("/studio/{storeId}")
    public ResponseEntity<?> deleteStudio(@PathVariable(name = "storeId") Long storeId){
        adminService.deleteStudio(storeId);
        return ResponseEntity.ok().body("studio 삭제되었습니다.");
    }

    @Operation(summary = "사진작가 생성", description = "ADMIN 회원의 사진작가 생성 api입니다.")
    @PostMapping("/photographer")
    public ResponseEntity<CreatePhotographerResponseDTO> createPhotographer(@RequestBody CreatePhotographerRequestToTalDTO dto){
        CreatePhotographerResponseDTO savedPhotographer = adminService.createPhotographer(dto);
        return ResponseEntity.created(URI.create("/photographer/" + savedPhotographer.getStoreId())).body(savedPhotographer);
    }

    @Operation(summary = "사진작가 조회", description = "ADMIN 회원의 사진작가 조회 api입니다.")
    @GetMapping("/photographer/{storeId}")
    public ResponseEntity<AdminSelectPhotographerResponseDTO> selectPhotographer(@PathVariable(name = "storeId") Long storeId){
        AdminSelectPhotographerResponseDTO selectedPhotographer = adminService.selectPhotographer(storeId);
        return ResponseEntity.ok().body(selectedPhotographer);
    }

    @Operation(summary = "사진작가 수정", description = "ADMIN 회원의 사진작가 수정 api입니다.")
    @PatchMapping("/photographer/{storeId}")
    public ResponseEntity<AdminSelectPhotographerResponseDTO> updatePhotographer(@RequestBody UpdatePhotographerRequestDTO changedDTO, @PathVariable(name = "storeId") Long storeId){
        AdminSelectPhotographerResponseDTO updatedPhotographer = adminService.updatePhotographer(changedDTO, storeId);
        return ResponseEntity.ok().body(updatedPhotographer);
    }

    @Operation(summary = "사진작가 삭제", description = "ADMIN 회원의 사진작가 삭제 api입니다.")
    @DeleteMapping("/photographer/{storeId}")
    public ResponseEntity<?> deletePhotographer(@PathVariable(name = "storeId") Long storeId){
        adminService.deletePhotographer(storeId);
        return ResponseEntity.ok().body("photographer 삭제되었습니다");
    }


}
