package com.example.testaplication.tarea4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Distro> distribuciones;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_lista);

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle("Listado de Distros");

        poblarListado();

        DistrosAdapter adapter;
        adapter = new DistrosAdapter(this, distribuciones);

        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter); // asignamos los datos
        listView.setOnItemClickListener(this); // // asignamos el escucha de eventos
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;// super.onOptionsItemSelected(item);
    }
    
    private void poblarListado() {
        distribuciones = new ArrayList<Distro>();

        distribuciones.add(new Distro(R.drawable.debian, "Debian GNU/Linux","APT", "16 de agosto de 1993", "es un sistema operativo libre, desarrollado por miles de voluntarios de todo el mundo, que colaboran a través de Internet.\n" +
                "La dedicación de Debian al software libre, su base de voluntarios, su naturaleza no comercial y su modelo de desarrollo abierto la distingue de otras distribuciones del sistema operativo GNU. Todos estos aspectos y más se recogen en el llamado Contrato Social de Debian.\n" +
                "Nació en el año 1993, de la mano del proyecto Debian, con la idea de crear un sistema GNU usando Linux como núcleo ya que el proyecto Debian, organización responsable de su mantenimiento en la actualidad, también desarrolla sistemas GNU basados en otros núcleos (Debian GNU/Hurd, Debian GNU/NetBSD y Debian GNU/kFreeBSD)."));
        distribuciones.add(new Distro(R.drawable.elementary, "Elementary OS","apt-get", "31 de marzo de 2011", "es una distribución Linux basada en Ubuntu LTS (a su vez basada en Debian). Usa un entorno de escritorio basado en GNOME con un shell propio llamado Pantheon. Dicho entorno destaca por ser más ligero que GNOME Shell y por la integración con otras aplicaciones de elementary OS como Plank (dock), Epiphany (el navegador web), Scratch (editor simple de texto) o Birdie (cliente de Twitter). Como gestor de ventanas usa Gala, basado en Mutter."));
        distribuciones.add(new Distro(R.drawable.linux_mint, "Linux Mint", "APT", "27 de agosto de 2006", "es una distribución de GNU/Linux comunitaria de origen franco-irlandesa basada en Ubuntu, y a su vez en Debian, que tiene por objetivo proveer ´un sistema operativo moderno, elegante y cómodo que sea tanto poderoso como fácil de usar´. Linux Mint soporta varios formatos y códecs multimedia al incluir software propietario y empaquetado con una variedad de aplicaciones gratuitas y de código abierto.\u200B"));
        distribuciones.add(new Distro( R.drawable.opensuse,"openSUSE", "Zypper", "Marzo de 1994", "es el nombre de la distribución y el proyecto libre auspiciado por SUSE Linux GmbH (una división independiente de Blitz 18-679 GmbH), y AMD\u200B para el desarrollo y mantenimiento de un sistema operativo basado en GNU/Linux. Después de adquirir SUSE Linux en enero de 2004, Novell decidió lanzar SUSE Linux Professional como un proyecto completamente de código abierto, involucrando a la comunidad en el proceso de desarrollo. La versión inicial fue una versión beta de SUSE Linux 10.0, y se continúa esa denominación para las versiones actuales, con la excepción de la serie openSUSE Leap."));
        distribuciones.add(new Distro( R.drawable.slackware, "Slackware Linux", "pkgtool, slackpkg", "16 de julio de 1993", "es una distribución del sistema operativo GNU/Linux creada en 1993 por Patrick Volkerding orientada a usuarios avanzados. Basada originalmente en SLS Linux, Slackware es la distribución de GNU/Linux más antigua aún en mantenimiento.\n" +
                "\n" +
                "Su versión actual es la versión 14.2, publicada el 1 de julio de 2016. Contiene un programa de instalación sencillo de utilizar, aunque está basado en texto, a diferencia de otros entornos de instalación basados en ambientes gráficos. También cuenta con extensa documentación en inglés y un sistema de gestión de paquetes basado en menús. Lo que diferencia a Slackware Linux de otras distribuciones Linux es que la misma se asemeja en alto grado a los sistemas operativos Unix. A tal efecto, incluye software que normalmente no se encuentra en otras distribuciones Linux, tal como la última versión del entorno de comandos Korn shell."));
        distribuciones.add(new Distro(R.drawable.ubuntu,"Ubuntu","APT", "20 de octubre de 2004", "es un sistema operativo de software libre y código abierto. Es una distribución de Linux basada en Debian. Puede correr en computadores de escritorio y servidores. Está orientado al usuario promedio, con un fuerte enfoque en la facilidad de uso y en mejorar la experiencia del usuario. Está compuesto de múltiple software normalmente distribuido bajo una licencia libre o de código abierto. Estadísticas web sugieren que la cuota de mercado de Ubuntu dentro de las distribuciones Linux es, aproximadamente, del 52%,\u200B y con una tendencia a aumentar como servidor web."));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Al hacer click sobre uno de los items del ListView mostramos los
        // datos en los TextView.
        Distro distro = distribuciones.get(position);

        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("distro",  distro);
        startActivity(intent);
        //return true;
    }


}
