/**
 * 
 */
package br.com.softplan.desafio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.softplan.BaseSeleniumTest;

/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class CadastraUsuarioTest  extends BaseSeleniumTest {

	@Test
	public void cadastraUsuarioEValidaTest() {
		driver.get("http://localhost:8080/usuarios/");
		
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]/input")));
		driver.findElement(By.xpath("//td[2]/input")).click();
	    
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]/input")));
		driver.findElement(By.xpath("//td[2]/input")).sendKeys("Teste");
	    
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]/td[2]/input")));
		driver.findElement(By.xpath("//tr[2]/td[2]/input")).click();
	    
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]/td[2]/input")));
		driver.findElement(By.xpath("//tr[2]/td[2]/input")).sendKeys("teste@gmail.com");
	    
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,\'Salvar\')]")));
		driver.findElement(By.xpath("//span[contains(.,\'Salvar\')]")).click();
	    
		waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(2) > .ui-messages-info-summary")));
	    assertThat(driver.findElement(By.cssSelector("li:nth-child(2) > .ui-messages-info-summary")).getText(), is("Usuário: Teste"));
	    
	    waitDefault.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(3) > .ui-messages-info-summary")));
	    assertThat(driver.findElement(By.cssSelector("li:nth-child(3) > .ui-messages-info-summary")).getText(), is("E-mail: teste@gmail.com"));
	}

}