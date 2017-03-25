package br.sceweb.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static EmpresaDAO empresaDao;
	public static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDao = new EmpresaDAO();
		empresa = new Empresa();

		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}

	/**
	 * Cadastro de empresa com sucesso.
	 */
	@Test
	public void CT01UC01FB_cadastrar_empresa_com_sucesso() {
		assertEquals(1, empresaDao.adiciona(empresa));
	}

	/**
	 * Validação de inserção dos dados.
	 */
	@Test
	public void CT02UC01A01_verifica_validacao_dos_dados_com_sucesso() {
		Empresa empresaCamposValidos = new Empresa();

		try {
			empresaCamposValidos.setCnpj("78666151000170");
			empresaCamposValidos.setNomeDaEmpresa("Open informatica Ltda");
			empresaCamposValidos.setNomeFantasia("Open informatica");
			empresaCamposValidos.setEndereco("Av. Aguia de Haia 1783");
			empresaCamposValidos.setTelefone("12121212");
		} catch (Exception e) {
			fail("Dados inválidos.");
		}
	}

	/**
	 * Validação de dados para Nome da Empresa inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void CT03UC01A02_nomeDaEmpresa_invalido() {
		empresa.setNomeDaEmpresa("");
	}

	/**
	 * Validação de dados para CNPJ inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void CT04UC01A03_cnpj_invalido() {
		empresa.setCnpj("");
	}

	/**
	 * Validação de dados para Nome Fantasia inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void CT05UC01A04_nomeFantasia_invalido() {
		empresa.setNomeFantasia("");
	}

	/**
	 * Validação de dados para Endereço inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void CT06UC01A05_endereco_invalido() {
		empresa.setEndereco("");
	}

	/**
	 * Validação de dados para Telefone inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void CT07UC01A06_telefone_invalido() {
		empresa.setTelefone("");
	}

	/**
	 * Validação do CNPJ.
	 */
	@Test
	public void CT08UC01A07_valida_cnpj() {
		empresa.setCnpj("78666151000170");
		assertEquals("78666151000170", empresa.getCnpj());
	}

	/**
	 * Validação do Nome da Empresa.
	 */
	@Test
	public void CT09UC01A08_valida_nome_da_empresa() {
		empresa.setNomeDaEmpresa("Open informatica Ltda");
		assertEquals("Open informatica Ltda", empresa.getNomeDaEmpresa());
	}

	/**
	 * Validação do Nome Fantasia.
	 */
	@Test
	public void CT10UC01A09_valida_nome_fantasia() {
		empresa.setNomeFantasia("Open informatica");
		assertEquals("Open informatica", empresa.getNomeFantasia());
	}

	/**
	 * Validação do Endereço.
	 */
	@Test
	public void CT11UC01A10_valida_endereco() {
		empresa.setEndereco("Av. Aguia de Haia 1783");
		assertEquals("Av. Aguia de Haia 1783", empresa.getEndereco());
	}

	/**
	 * Validação do Telefone.
	 */
	@Test
	public void CT12UC01A11_valida_telefone() {
		empresa.setTelefone("12121212");
		assertEquals("12121212", empresa.getTelefone());
	}

	@After
	public void teardown() {
		empresaDao.exclui("78666151000170");
		empresaDao.exclui("89424232000180");
	}
}
