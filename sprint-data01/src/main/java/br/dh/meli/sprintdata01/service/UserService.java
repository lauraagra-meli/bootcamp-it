package br.dh.meli.sprintdata01.service;

import br.dh.meli.sprintdata01.exception.BadRequestException;
import br.dh.meli.sprintdata01.exception.UserNotFoundException;
import br.dh.meli.sprintdata01.model.UserBD;
import br.dh.meli.sprintdata01.repository.IUserDbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    // JPA cria a classe, implementa o conteudo dos metodos, gera um objeto e entrega tudo pronto
    // consumindo o crud
    @Autowired
    private IUserDbRepo repo;

    @Override
    // metodo que busca no banco
    public UserBD getUserById(long id) {
        // return (UserBD) repo.findById(id).orElse(null); // fazendo um casting pra transformar pra UserDb
        // return repo.findById(id).get(); // outra forma
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado - id: " + id)); // outra forma usando Optional
    }

    @Override
    public UserBD insertUser(UserBD newUser) {
        if (newUser.getId() > 0) {
            throw new BadRequestException("O usuário não pode ter id para ser inserido.");
        } // pra não cair na linha de baixo caso o user exista
        return repo.save(newUser); // save insere ou atualiza - se user existe cria, se não, atualiza
    }

    @Override
    public UserBD update(UserBD user) {
        UserBD userFound = getUserById(user.getId());
//        userFound.setName(user.getName());
//        userFound.setEmail(user.getEmail());

        return repo.save(user);
    }

    @Override
    public UserBD updatePartial(long id, Map<String, String> changes) {
        UserBD userFound = getUserById(id);

        changes.forEach((attribute, value) -> {
            switch (attribute) {
                case "name": userFound.setName(value); break; // caso o atributo seja o campo name
                case "email": userFound.setEmail(value); break; // caso o atributo seja o campo email
            }
        });

        return repo.save(userFound);
    }

    @Override
    public void deleteUser(long id) {
        UserBD userFound = getUserById(id);
        repo.delete(userFound);

        // TODO: lancar exception userNotFOund
    }

    @Override
    public List<UserBD> listAll() {
        return (List<UserBD>) repo.findAll(); // usando o casting porque estamos usando o crud repositou
    }

    // na documentacao do JPA tem varios metodos predefinidos com nomes definidos, um exemplo disso é o findByEmail
    @Override
    public UserBD findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
