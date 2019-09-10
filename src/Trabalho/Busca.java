package Trabalho;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 * @author ktia-
 */
public class Busca {

    boolean tem = false;
    String registro = null;

    public boolean pesquisaId(int id) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        InputStream is = new FileInputStream("src\\cadastro.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        StringBuffer stringBuffer = new StringBuffer("");
        String line = null;

        while ((tem == false) && (line = br.readLine()) != null) {
            stringBuffer.append(line);
            Matcher m = Pattern.compile("ID: " + id + ",").matcher(line);
            tem = m.find();
            registro = line;
        }
        br.close();
        return tem;
    }

    public String buscaIdRes(String id) throws UnsupportedEncodingException, IOException {
        int a = Integer.parseInt(id);
        pesquisaId(a);
        if (tem) {
            return "Encontrado\n" + registro;
        } else {
            return "Não encotrado";
        }
    }

    public boolean pesquisaNome(String nome) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        InputStream is = new FileInputStream("src\\cadastro.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuffer stringBuffer = new StringBuffer("");
        String line = null;

        while ((tem == false) && (line = br.readLine()) != null) {
            stringBuffer.append(line);
            Matcher m = Pattern.compile("Nome: " + nome).matcher(line);
            tem = m.find();
            registro = line;
        }
        br.close();
        return tem;

    }
    
    public String buscaNomeRes(String nome) throws UnsupportedEncodingException, IOException {
        pesquisaNome(nome);
        if (tem) {
            return "Encontrado\n" + registro;
        } else {
            return "Não encotrado";
        }

    }

    public String listar() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        InputStream is = new FileInputStream("src\\cadastro.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        StringBuffer stringBuffer = new StringBuffer("");
        String line = null;
        
        String displayMessage = "\tRegistro:\n";
        
        while ((line = br.readLine()) != null) {
            stringBuffer.append(line);
            displayMessage += line + "\n";
        }
        br.close();
        return displayMessage;
    }

}
