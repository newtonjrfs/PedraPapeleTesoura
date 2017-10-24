package newton.com.pedrapapeletesoura;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void selecionaPedra(View view){
        this.opcaoSelecionada ("pedra");
    }


    public void selecionaPapel(View view){
        this.opcaoSelecionada ("papel");
    }


    public void selecionaTesoura(View view){
        this.opcaoSelecionada ("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        String[] opcoes = {"pedra","papel","tesoura"};

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textoResultado);

        //gerar numero aleatorio para escolha do App
        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];

        switch (escolhaApp){

            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura" )||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel")

                ){//app ganhador

            textResultado.setText("O Usuario e o vencedor");

        }else if (
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura" )||
                        (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel")
                ){//jogador ganhador
            textResultado.setText("O APP e o vencedor");
        }else{//empate
            textResultado.setText("O jogo ficou empatado");
        }



    }
}
