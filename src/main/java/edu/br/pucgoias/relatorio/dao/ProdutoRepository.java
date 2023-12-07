package edu.br.pucgoias.relatorio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.br.pucgoias.relatorio.modelo.produto;


public interface ProdutoRepository extends JpaRepository<produto, Long> {
    // Aqui você pode adicionar métodos específicos, se necessário
}

