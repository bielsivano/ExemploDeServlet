package br.com.ibm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contasbancarias extends HttpServlet {

    private final Map<String, ContaBancaria> contas = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");



        if ("criar".equals(action)) {
            String numeroConta = request.getParameter("numeroConta");
            double saldoInicial = Double.parseDouble(request.getParameter("saldoInicial"));
            ContaBancaria conta = new ContaBancaria(numeroConta, saldoInicial);
            contas.put(numeroConta, conta);
            out.println("Conta criada com sucesso!");
        } else if ("visualizar".equals(action)) {
            String numeroConta = request.getParameter("numeroConta");
            ContaBancaria conta = contas.get(numeroConta);
            if (conta != null) {
                out.println("Número da Conta: " + conta.getNumeroConta() + "<br>");
                out.println("Saldo: " + conta.getSaldo() + "<br>");
            } else {
                out.println("Conta não encontrada.");
            }
        } else if ("atualizar".equals(action)) {
            String numeroConta = request.getParameter("numeroConta");
            double valor = Double.parseDouble(request.getParameter("valor"));
            ContaBancaria conta = contas.get(numeroConta);
            if (conta != null) {
                conta.depositar(valor);
                out.println("Depósito realizado com sucesso! Saldo atual: " + conta.getSaldo() + "<br>");
            } else {
                out.println("Conta não encontrada.");
            }
        }
    }
}

 class ContaBancaria {
    protected String numeroConta;
    protected double saldo;

    protected ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    protected String getNumeroConta() {
        return numeroConta;
    }

    protected double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}



