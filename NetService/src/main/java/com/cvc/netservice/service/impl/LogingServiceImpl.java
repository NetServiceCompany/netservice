package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.User;
import com.cvc.netservice.repository.LogingRepository;
import com.cvc.netservice.service.LogingService;
import com.cvc.netservice.service.dto.UserDTO;
import com.cvc.netservice.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.annotations.Cacheable;


@Service
@Transactional
public class LogingServiceImpl implements LogingService {

    private final LogingRepository logingRepository;

    private final UserMapper userMapper;

    public LogingServiceImpl(LogingRepository logingRepository, UserMapper userMapper) {
        this.logingRepository = logingRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable("findOne")
    @Transactional(readOnly = true)
    public UserDTO findOne(Long id) {
        User user = logingRepository.findOne(id);
        return userMapper.toUserDTO(user);
    }
}
