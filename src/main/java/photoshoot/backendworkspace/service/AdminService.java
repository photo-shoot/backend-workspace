package photoshoot.backendworkspace.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.dto.detail.CreateDetailDTO;
import photoshoot.backendworkspace.dto.photographer.create.request.CreatePhotographerRequestDTO;
import photoshoot.backendworkspace.dto.photographer.create.request.CreatePhotographerRequestToTalDTO;
import photoshoot.backendworkspace.dto.photographer.create.response.CreatePhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.select.AdminSelectPhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.update.UpdatePhotographerRequestDTO;
import photoshoot.backendworkspace.dto.price.CreatePriceDTO;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;
import photoshoot.backendworkspace.dto.studio.create.request.CreateStudioRequestDTO;
import photoshoot.backendworkspace.dto.studio.create.request.CreateStudioRequestToTalDTO;
import photoshoot.backendworkspace.dto.studio.create.response.CreateStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.select.AdminSelectStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.update.UpdateStudioRequestDTO;
import photoshoot.backendworkspace.entity.*;
import photoshoot.backendworkspace.exception.CustomException;
import photoshoot.backendworkspace.repository.AdminRepository;
import photoshoot.backendworkspace.repository.PhotographerRepository;
import photoshoot.backendworkspace.repository.StoreRepository;
import photoshoot.backendworkspace.repository.StudioRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {
    private final StoreRepository storeRepository;
    private final StudioRepository studioRepository;
    private final PhotographerRepository photographerRepository;
    private final AdminRepository adminRepository;

    @Data
    public class commReturnForCreateStore{
        Detail createdDetail;
        Price createdPrice;
        Admin admin;
    }

    @Transactional
    public CreateStudioResponseDTO createStudio(CreateStudioRequestToTalDTO dto){
        CreateStoreRequestDTO storeDTO = dto.getCreateStoreRequestDTO();
        CreateStudioRequestDTO studioDTO = dto.getCreateStudioRequestDTO();
        commReturnForCreateStore comm = createCommForStore(storeDTO);
        Studio createdStudio = Studio.create(storeDTO, studioDTO, comm.getCreatedDetail(), comm.getCreatedPrice(), comm.getAdmin());
        CreateStudioResponseDTO savedStudioDTO = Studio.toCreateResponseDTO((Studio) storeRepository.save(createdStudio));
        return savedStudioDTO;
    }

    public AdminSelectStudioResponseDTO selectStudio(Long storeId){
        AdminSelectStudioResponseDTO selectedStudio = Studio.toAdminSelectResponseDTO(studioRepository.findByStoreId(storeId).orElseThrow(() -> new CustomException("Studio가 존재하지 않습니다.", HttpStatus.NOT_FOUND)));
        return selectedStudio;
    }

    @Transactional
    public AdminSelectStudioResponseDTO updateStudio(UpdateStudioRequestDTO changedDTO, Long storeId){
        Studio origin = studioRepository.findByStoreId(storeId).orElseThrow(() -> new CustomException("해당 studio가 존재하지 않습니다.", HttpStatus.NOT_FOUND));
        if(changedDTO.getTitle() != null) origin.setTitle(changedDTO.getTitle());
        if(changedDTO.getShortDescription() != null) origin.setShortDescription(changedDTO.getShortDescription());
        if(changedDTO.getProfileImgName() != null) origin.setProfileImgName(changedDTO.getProfileImgName());
        if(changedDTO.getProfileImgPath() != null) origin.setProfileImgPath(changedDTO.getProfileImgPath());
        if(changedDTO.getDetail() != null) origin.setDetail(changedDTO.getDetail());
        if(changedDTO.getPrice() != null) origin.setPrice(changedDTO.getPrice());
        if(changedDTO.getAddress() != null) origin.setAddress(changedDTO.getAddress());
        //minuteFromSpot 업데이트하는 코드 추가되어야함.
        if(changedDTO.getSpot() != null) origin.setSpot(changedDTO.getSpot());
        AdminSelectStudioResponseDTO updatedStudio = Studio.toAdminSelectResponseDTO(studioRepository.save(origin));
        return updatedStudio;
    }

    @Transactional
    public void deleteStudio(Long storeId){
        Studio studio = studioRepository.findByStoreId(storeId).orElseThrow(()->new CustomException("해당 studio가 존재하지 않아 삭제할 수 없습니다.", HttpStatus.NOT_FOUND));
        studioRepository.delete(studio);
    }

    @Transactional
    public CreatePhotographerResponseDTO createPhotographer(CreatePhotographerRequestToTalDTO dto){
        CreateStoreRequestDTO storeDTO = dto.getCreateStoreRequestDTO();
        CreatePhotographerRequestDTO photographerDTO = dto.getCreatePhotographerRequestDTO();
        commReturnForCreateStore comm = createCommForStore(storeDTO);
        Photographer createdPhotographer = Photographer.create(storeDTO, photographerDTO, comm.getCreatedDetail(), comm.getCreatedPrice(), comm.getAdmin());
        CreatePhotographerResponseDTO savedPhotographerDTO = Photographer.toCreateResponseDTO((Photographer) photographerRepository.save(createdPhotographer));
        return savedPhotographerDTO;
    }

    public AdminSelectPhotographerResponseDTO selectPhotographer(Long storeId){
        AdminSelectPhotographerResponseDTO selectedPhotographer = Photographer.toAdminSelectResponseDTO(photographerRepository.findByStoreId(storeId).orElseThrow(()->new CustomException("선택하신 photographer가 없습니다.", HttpStatus.NOT_FOUND)));
        return selectedPhotographer;
    }

    @Transactional
    public AdminSelectPhotographerResponseDTO updatePhotographer(UpdatePhotographerRequestDTO changedDTO, Long storeId){
        Photographer origin = photographerRepository.findByStoreId(storeId).orElseThrow(() -> new CustomException("해당 photographer가 존재하지 않습니다.", HttpStatus.NOT_FOUND));
        if(changedDTO.getTitle() != null) origin.setTitle(changedDTO.getTitle());
        if(changedDTO.getShortDescription() != null) origin.setShortDescription(changedDTO.getShortDescription());
        if(changedDTO.getProfileImgName() != null) origin.setProfileImgName(changedDTO.getProfileImgName());
        if(changedDTO.getProfileImgPath() != null) origin.setProfileImgPath(changedDTO.getProfileImgPath());
        if(changedDTO.getDetail() != null) origin.setDetail(changedDTO.getDetail());
        if(changedDTO.getPrice() != null) origin.setPrice(changedDTO.getPrice());
        if(changedDTO.getPlace() != null) origin.setPlace(changedDTO.getPlace());
        //minuteFromSpot 업데이트하는 코드 추가되어야함.
        if(changedDTO.getIsBusinessTrip() != null) origin.setIsBusinessTrip(changedDTO.getIsBusinessTrip());
        AdminSelectPhotographerResponseDTO savedPhotographer = Photographer.toAdminSelectResponseDTO(photographerRepository.save(origin));
        return savedPhotographer;
    }

    @Transactional
    public void deletePhotographer(Long storeId){
        Photographer photographer = photographerRepository.findByStoreId(storeId).orElseThrow(()->new CustomException("해당 photographer가 존재하지 않아 삭제할 수 없습니다.", HttpStatus.NOT_FOUND));
        photographerRepository.delete(photographer);
    }


    public List<Admin> all(){
        return adminRepository.findAll();
    }

    private commReturnForCreateStore createCommForStore(CreateStoreRequestDTO storeDTO){
        commReturnForCreateStore res = new commReturnForCreateStore();
        CreateDetailDTO detailDTO = storeDTO.getCreateDetailDTO();
        List<CreatePriceDTO> priceDTOList = storeDTO.getCreatePriceDTOList();
        res.setCreatedDetail(Detail.create(detailDTO));
        res.setCreatedPrice(Price.create(priceDTOList));
        res.setAdmin(adminRepository.findById(storeDTO.getAdminId()).orElseThrow(() -> new CustomException("Studio 및 Photographer 생성 Admin 계정이 유효하지 않습니다.", HttpStatus.NOT_FOUND)));
        return res;
    }

}
