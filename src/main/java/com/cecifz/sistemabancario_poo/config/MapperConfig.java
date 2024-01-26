package com.cecifz.sistemabancario_poo.config;

import com.cecifz.sistemabancario_poo.dto.AccountDto;
import com.cecifz.sistemabancario_poo.dto.CityDto;
import com.cecifz.sistemabancario_poo.model.Account;
import com.cecifz.sistemabancario_poo.model.City;
import com.cecifz.sistemabancario_poo.model.Client;
import com.cecifz.sistemabancario_poo.dto.ClientDto;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        TypeMap<Client, ClientDto> clientMap = mapper.createTypeMap(Client.class, ClientDto.class);
        clientMap.addMapping(e -> e.getFullName(), (dest, v) -> dest.setFullName((String) v));
        clientMap.addMapping(e -> e.getFullAddress(), (dest, v) -> dest.setAddress((String) v));

     /*   TypeMap<Account, AccountDto> accountMap = mapper.createTypeMap(Account.class, AccountDto.class);
        accountMap.addMapping(e -> e.getClient().getFullName(), (dest, v) -> dest.setFullName((String) v));
*/
        TypeMap<City, CityDto> CityMap = mapper.createTypeMap(City.class, CityDto.class);
        CityMap.addMapping(e -> e.getProvince().getDescription(), (dest, v) -> dest.setProvince((String) v));

        return mapper;
    }


}
