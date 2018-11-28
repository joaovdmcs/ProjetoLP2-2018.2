package doe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerUsuarioTest {
	
	private ControllerUsuario controllerUsuario;
	
	@BeforeEach
	public void Before() {
		controllerUsuario = new ControllerUsuario();
		controllerUsuario.cadastraDoador("59238650111", "Satya", "satya@br", "(83) 99221-2571", "PESSOA_FISICA");
		controllerUsuario.cadastraDoador("50270271338", "Lucas", "lucas12@br", "(83) 99982-9231", "PESSOA_FISICA");
		controllerUsuario.cadastraDoador("10357071312", "Lucas", "lucas34@br", "(83) 98249-1298", "PESSOA_FISICA");
		controllerUsuario.cadastraDoador("12094912484", "Lucas", "lucas56@br", "(83) 94813-4871", "PESSOA_FISICA");
	}

	@Test
	public void testCadastraDoadorIdNulo() {
		try {
			controllerUsuario.cadastraDoador(null, "Elizabeth Ashe", "elizabethcalamity@br", "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorIdVazio() {
		try {
			controllerUsuario.cadastraDoador("", "Elizabeth Ashe", "elizabethcalamity@br", "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorNomeNulo() {
		try {
			controllerUsuario.cadastraDoador("70513372911", null, "elizabethcalamity@br", "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: nome nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorNomeVazio() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "", "elizabethcalamity@br", "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: nome nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorEmailNulo() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", null, "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: email nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorEmailVazio() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", "", "(83) 92918-0211", "PESSOA_FISICA");
			fail("Entrada invalida: email nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorCelularNulo() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", "elizabethcalamity@br", null, "PESSOA_FISICA");
			fail("Entrada invalida: celular nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorCelularVazio() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", "elizabethcalamity@br", "", "PESSOA_FISICA");
			fail("Entrada invalida: celular nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorClasseNula() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", "elizabethcalamity@br", "(83) 92918-0211", null);
			fail("Entrada invalida: classe nao pode ser vazia ou nula.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorClasseVazia() {
		try {
			controllerUsuario.cadastraDoador("70513372911", "Elizabeth Ashe", "elizabethcalamity@br", "(83) 92918-0211", "");
			fail("Entrada invalida: classe nao pode ser vazia ou nula.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testCadastraDoadorJaExistente() {
		try {
			controllerUsuario.cadastraDoador("59238650111", "Satya", "satya@br", "(83) 99221-2571", "PESSOA_FISICA");
			fail("Usuario ja existente.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorIdNulo() {
		try {
			controllerUsuario.pesquisaUsuarioPorId(null);
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorIdVazio() {
		try {
			controllerUsuario.pesquisaUsuarioPorId("");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorIdUsuarioNaoCadastrado() {
		try {
			controllerUsuario.pesquisaUsuarioPorId("123123123");
			fail("Usuario nao encontrado.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorId() {
		assertEquals("Satya/59238650111, satya@br, (83) 99221-2571, status: doador", controllerUsuario.pesquisaUsuarioPorId("59238650111"));
	}
	
	@Test
	public void testPesquisaUsuarioPorNomeNulo() {
		try {
			controllerUsuario.pesquisaUsuarioPorId(null);
			fail("Entrada invalida: nome nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorNomeVazio() {
		try {
			controllerUsuario.pesquisaUsuarioPorId("");
			fail("Entrada invalida: nome nao pode ser vazio ou nulo.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorNomeNaoCadastrado() {
		try {
			controllerUsuario.pesquisaUsuarioPorId("abc");
			fail("Usuario nao encontrado.");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testPesquisaUsuarioPorNome1() {
		assertEquals("Satya/59238650111, satya@br, (83) 99221-2571, status: doador", controllerUsuario.pesquisaUsuarioPorNome("Satya"));
	}
	
	@Test
	public void testPesquisaUsuarioPorNome2() {
		assertEquals("Lucas/50270271338, lucas12@br, (83) 99982-9231, status: doador | Lucas/10357071312, lucas34@br, (83) 98249-1298, status: doador | Lucas/12094912484, lucas56@br, (83) 94813-4871, status: doador", 
				controllerUsuario.pesquisaUsuarioPorNome("Lucas"));
	}
	
	@Test
	public void testAtualizaUsuarioIdNulo() {
		try {
			controllerUsuario.atualizaUsuario(null, "Satya", "satya@br", "(83) 99221-2571");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testAtualizaUsuarioIdVazio() {
		try {
			controllerUsuario.atualizaUsuario("", "Satya", "satya@br", "(83) 99221-2571");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testAtualizaUsuarioNaoCadastrado() {
		try {
			controllerUsuario.atualizaUsuario("123123123", "Satya", "satya@br", "(83) 99221-2571");
			fail("Usuario nao encontrado.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testAtualizaUsuario1() {
		assertEquals("Satya/59238650111, satya@com.br, (83) 99221-2571, status: doador", controllerUsuario.atualizaUsuario("59238650111", "", "satya@com.br", ""));
	}
	
	@Test
	public void testAtualizaUsuario2() {
		assertEquals("Satya/59238650111, satya@br, (83) 11111-1111, status: doador", controllerUsuario.atualizaUsuario("59238650111", "", "", "(83) 11111-1111"));
	}
	
	@Test
	public void testAtualizaUsuario3() {
		assertEquals("Maria/59238650111, satya@br, (83) 99221-2571, status: doador", controllerUsuario.atualizaUsuario("59238650111", "Maria", "", ""));
	}
	
	@Test
	public void testRemoveUsuarioIdNulo() {
		try {
			controllerUsuario.removeUsuario(null);
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testRemoveUsuarioIdVazio() {
		try {
			controllerUsuario.removeUsuario("");
			fail("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testRemoveUsuarioNaoCadastrado() {
		try {
			controllerUsuario.removeUsuario("123123123");
			fail("Usuario nao encontrado.");
		}catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	public void testRemoveUsuario() {
		controllerUsuario.removeUsuario("50270271338");
		assertEquals("Lucas/10357071312, lucas34@br, (83) 98249-1298, status: doador | Lucas/12094912484, lucas56@br, (83) 94813-4871, status: doador", 
				controllerUsuario.pesquisaUsuarioPorNome("Lucas"));
	}
	
}