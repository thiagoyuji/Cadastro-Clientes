/**
 * @author Julio de Souza Novaes 
 */
package com.cadastro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.modelo.Cliente;





public interface  RepositorioCadastro extends JpaRepository<Cliente, Long>{

}
