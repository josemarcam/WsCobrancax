/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobranca_varredura;

import java.io.File;

/**
 *
 * @author josemartins
 */
public class varredura extends Thread {
    public String varrer(String caminho, String extensao) throws Exception{
        HttpExemplo u = new HttpExemplo();
       String extensaom = extensao.toUpperCase();
        File file = new File(caminho);
                for (String arquivos : file.list()) {
			if (arquivos.endsWith(extensao) | arquivos.endsWith(extensaom) ) {
                            String c = caminho+arquivos;
                            u.getSendRemessa(c);
                        } else {
			}
		}
        return caminho;
    }
}
