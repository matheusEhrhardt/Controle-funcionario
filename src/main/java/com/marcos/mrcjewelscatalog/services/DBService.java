package com.marcos.mrcjewelscatalog.services;

import com.marcos.mrcjewelscatalog.entities.Category;
import com.marcos.mrcjewelscatalog.entities.Jewel;
import com.marcos.mrcjewelscatalog.entities.Role;
import com.marcos.mrcjewelscatalog.entities.User;
import com.marcos.mrcjewelscatalog.repositories.CategoryRepository;
import com.marcos.mrcjewelscatalog.repositories.JewelRepository;
import com.marcos.mrcjewelscatalog.repositories.RoleRepository;
import com.marcos.mrcjewelscatalog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
    private final JewelRepository jewelRepository;
    private final PasswordEncoder passwordEncoder;

    public void instanciaDB(){

        Role role1 = new Role(null,"ROLE_ADMIN");
        Role role2 = new Role(null, "ROLE_USER");

        User user1 = new User(null,
                "Marcos Andrade",
                "marcos@email.com",
                passwordEncoder.encode("123"), List.of(role1,role2));
        User user2 = new User(null,
                "Rildo Andrade",
                "rildo@email.com",
                passwordEncoder.encode("123"), List.of(role2));

        Category category1 = new Category(null, "Colar");
        Category category2 = new Category(null, "Pulseira");
        Category category3 = new Category(null, "Anel");

        Jewel jwl1 = new Jewel(
                null,
                "Colar de Ouro",
                "Colar de ouro 25 quilates estilo rapper",
                15.8,
                "Tamanho Grande",
                1800.25,
                category1);
        Jewel jwl2 = new Jewel(
                null,
                "Colar de Prata",
                "Colar de Prata estilo rapper",
                null,
                "Tamanho Medio",
                900.25,
                category1);
        Jewel jwl3 = new Jewel(
                null,
                "Pulseira de Ouro",
                "Pulseiro de ouro estilo casual",
                11.4,
                "Tamanho Grande",
                400.25,
                category2);
        Jewel jwl4 = new Jewel(
                null,
                "Anel de Formatura",
                "Anel de formatura, customziado para seu curso.",
                20.4,
                "Medido do Cliente",
                800.25,
                category3);

        roleRepository.saveAll(List.of(role1,role2));
        userRepository.saveAll(List.of(user1,user2));


        categoryRepository.saveAll(List.of(category1,category2,category3));
        jewelRepository.saveAll(List.of(jwl1,jwl2,jwl3,jwl4));
    }
}
