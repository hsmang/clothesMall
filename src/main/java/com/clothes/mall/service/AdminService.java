package com.clothes.mall.service;

import com.clothes.mall.domain.admin.*;
import com.clothes.mall.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;


    /**
     * Admin 등록
     * @param adminSaveDto
     */
    public void save(AdminSaveDto adminSaveDto){
        adminRepository.save(adminSaveDto.toEntity());
    }


    /**
     * Admin 수정
     * @param adminUpdateDto
     */
    @Transactional
    public void update(Long id, AdminUpdateDto adminUpdateDto) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다.") );

        admin.update(adminUpdateDto);
    }

    /**
     * Admin 리스트
     * @param pageable
     * @return
     */
    public List<AdminResponseListDto> list(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return adminRepository.findAll(pageable).stream().map(AdminResponseListDto::new).collect(Collectors.toList());
    }


    /**
     * Admin 삭제
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));

        admin.delete(true);

    }

    /**
     * Admin 한 건 가져오기
     * @param id
     * @return
     */
    public AdminResponseDto findById(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
        AdminResponseDto adminResponseDto = new AdminResponseDto(admin);
        return adminResponseDto;
    }
}
