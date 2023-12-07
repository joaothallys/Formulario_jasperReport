package edu.br.pucgoias.relatorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import edu.br.pucgoias.relatorio.dao.ProdutoRepository;
import edu.br.pucgoias.relatorio.modelo.produto;
import edu.br.pucgoias.relatorio.modelo.produto_DTO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class VisualizaRelatorioService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public JasperPrint exportaRelatorio() throws IOException, JRException {
        // Recuperar todos os produtos do banco de dados
        List<produto> produtos = produtoRepository.findAll();

        // Converter entidade Produto para DTO (caso tenha DTO)
        List<produto_DTO> listProdutosDTO = produtos.stream()
                .map(produto_DTO::new)
                .collect(Collectors.toList());

        // Mudar o classPath de acordo com o arquivo
        File file = ResourceUtils.getFile("classpath:edu/br/pucgoias/relatorio/Simple_Blue_1.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listProdutosDTO);

        // Montar o relatório
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return jasperPrint;
    }
}

