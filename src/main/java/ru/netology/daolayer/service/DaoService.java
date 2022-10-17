package ru.netology.daolayer.service;

import org.springframework.stereotype.Service;
import ru.netology.daolayer.repositories.DaoRepository;

import java.util.List;

@Service
public class DaoService {
    private final DaoRepository daoRepository;

    public DaoService(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    public List<String> getProduct(String name) {
        return daoRepository.getProductName(name);
    }
}
