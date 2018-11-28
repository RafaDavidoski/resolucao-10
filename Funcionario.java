
import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.microsoft.azure.functions.*;

public class Function {

    @FunctionName ("helloserverless")
    public String hello(
        @HttpTrigger (
            name = "hellorest",
            methods = {HttpMethod.GET},
            route = "hello"
        )
        String x) {

		return "Hello REST World!";
	}

     @FunctionName ("getFuncionario")
    public Funcionario Readable (
        @HttpTrigger (
            name = "readpersonrest",
            methods = {HttpMethod.GET},
            route = "funcionario"
        ) 
        Funcionario funcionario) {

        return getAllFuncionario();
    }

    @FunctionName ("createFuncionario")
    public Funcionario create (
        @HttpTrigger (
            name = "createpersonrest",
            methods = {HttpMethod.POST},
            route = "funcionario"
        ) 
        Funcionario funcionario) {
		// TO DO funcionarios.add(funcionario);

		funcionario.setId(UUID.randomUUID());

		return funcionario;
	}

    @FunctionName ("updatefuncionario")
	public Funcionario update (
        @HttpTrigger (
            name = "updatefuncionariorest",
            methods = {HttpMethod.PUT},
            route = "funcionario"
        ) 
        Funcionario funcionario) {
		

		funcionario.setId(UUID.randomUUID());
		funcionario.setNome(funcionario.getNome() + " - updated!");

		return funcionario;
    }
    @FunctionName ("deletefuncionario")
    public Funcionario delete (
        @HttpTrigger (
            name = "deletefuncionariorest",
            methods = {HttpMethod.DELETE},
            route = "funcionario"
        ) 
        Funcionario funcionario) {

        for (Funcionario funcionario : funcionarios)
        {
            if(funcionario.getId()==id)
            {
               // funcionario.removerfuncionario(funcionario);
                break;
            }
    }
}

@Data
class Funcionario{
	private UUID id;
	private String nome;
	private int idade;
    private double salario;
}