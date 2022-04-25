package net.ktc.customer.services;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface IService <RequestDTO, ResponseDTO>{
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO getOne(String id);
    List<ResponseDTO> getAll();
    ResponseDTO update(RequestDTO requestDTO);
    void delete(String id) throws ResponseStatusException;
}
