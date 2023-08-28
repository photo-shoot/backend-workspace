package photoshoot.backendworkspace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import photoshoot.backendworkspace.dto.photographer.PhotographerListResponseDTO;
import photoshoot.backendworkspace.dto.studio.StudioListResponseDTO;
import photoshoot.backendworkspace.entity.Studio;
import photoshoot.backendworkspace.service.StudioService;

import java.util.List;

@Slf4j
@RestController
@Tag(name="Studio api")
public class StudioController {

    @Autowired
    StudioService studioService;

    // 나중에 util로 빼기
    @Operation(summary = "사진관 카테고리별 리스트(아직XXXX)", description = "카테고리별 사진관 리스트 불러오는 api입니다.")
    @GetMapping("/studio/hot3")
    public ResponseEntity<?> studioHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }

    @Operation(summary = "사진관 전체 리스트(아직 필터 적용 X)", description = "사진관 전체 리스트 조회 api입니다.")
    @GetMapping("/studios")
    public ResponseEntity<?> listStudios(
            @Parameter(description = "n번째 페이지") @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "한 페이지에 불러올 사진관 개수") @RequestParam(name = "pageSize", defaultValue = "8", required = false) int pageSize
            //@RequestParam(name = "filter", defaultValue = "0", required = false) String filter
    ) {
        StudioListResponseDTO studioListResponseDTO = studioService.listStudio(pageNo, pageSize);
        return ResponseEntity.ok().body(studioListResponseDTO);
    }

    @Operation(summary = "사진관 카테고리별 리스트(아직XXXX)", description = "카테고리별 사진관 리스트 불러오는 api입니다.")
    @GetMapping("/studios/{category}")
    public ResponseEntity<?> listCategoryStudios(
            @Parameter(description = "n번째 페이지") @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "한 페이지에 불러올 사진관 개수") @RequestParam(name = "pageSize", defaultValue = "0", required = false) int pageSize
            //@RequestParam(name = "category", defaultValue = "0", required = false) String category,
            //@RequestParam(name = "filter", defaultValue = "0", required = false) String filter
    ){
        StudioListResponseDTO studioListResponseDTO = studioService.listStudio(pageNo, pageSize);
        return ResponseEntity.ok().body(studioListResponseDTO);
    }

}
