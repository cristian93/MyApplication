package com.i053114.myapplication.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.i053114.myapplication.Utilities.Constants;

/**
 * Created by chris on 15/11/2017.
 */

public class SqliteHelper  extends SQLiteOpenHelper{

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_USERS);
        db.execSQL(Constants.CREATE_TABLE_IGLESIAS);
        db.execSQL(Constants.CREATE_TABLE_FAVORITOS);
        db.execSQL(Constants.CREATE_TABLE_COMMENTSUSERS);


        db.execSQL("INSERT INTO commentsUsers (titleComent, descriptionComment,idi2) VALUES ('aaa', 'aaa', 1)");


        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('san felipe', 'http://www.turismopasto.gov.co/images/iglesias/tsanfelipe2.jpg', 'Carrera 27 No. 11-31','Horarios Lunes a Sábado: 6:30 a.m. a 8:00 a.m. y 6:00 p.m. a 7:00 p.m. y Domingos: 6:00 a.m. a 11:00 a.m. y 6:00 p.m. a 7:30 a.m.','Su estilo es Rernacentista, de inigualable belleza. Se puede afirmar que este templo posee todas las características de la arquitectura religiosa, la nave central es de estilo gótico, se venera ahí la imagen de Jesús de Nazareno con la cruz a cuestas, las naves laterales poseen imágenes muy valiosas de talla en madera, artesanía de esta región. Llamada también de Jesús del Río')");


        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('Templo de Nuestra Señora de la Merced', 'https://pasto-ciudad-sorpresa.wikispaces.com/file/view/templo_cristo_rey_pasto_narino_colombia_031508.jpg/262194364/312x456/templo_cristo_rey_pasto_narino_colombia_031508.jpg'," +   " 'Cra. 22, Pasto, Nariño','Horarios Lunes a Sábado: 6:30 a.m. a 8:00 a.m. y 6:00 p.m. a 7:00 p.m. y Domingos: 6:00 a.m. a 11:00 a.m. y 6:00 p.m. a 7:30 a.m.','descripcion De estilo romantico clasico, conserva imagenes que datan en 1536. Su origen es español, traida por los padres Mercedarios en el año 1565. Se la denomina Patrona de pasto, cada año se celebra la fiesta de la Virgen de la Mercedes. La corona fue elaborada en Ecuador, su peso es de tres y media libras de oro con numerosas piedras preciosas')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('Templo de Nuestra Señora De Fátima', 'https://media-cdn.tripadvisor.com/media/photo-s/04/39/57/a2/fachada-iglesia-catedral.jpg', 'Cl. 19 #14-29, Pasto, Nariño','horario de luneas a domingo solo en las mañanas','descripcion Se ciñe al estilo bizantino, con arcos árabes e insinuaciones góticas que adornan la forma de la cruz. Obra del arquitecto pastuso Carlos Santacruz Burbano, el estilo de éste templo es de características románico-modernista. En el área de las naves se forma una amplia cruz. El altar se encuentra en el centro del crucero y en la parte superior del templete, que se sostiene con cuatro columnas torneadas en espiral, donde está la Virgen de Fátima')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('Templo de la Catedral', 'http://www.turismopasto.gov.co/images/iglesias/tfatima2.jpg', ' Carrera26 No. 23','horario Lunes a sabado de 8 a 10pm','Su estilo se ciñe a manifestaciones Románicas su reminiscencia adopta insinuaciones de la Basílica de san pedro, con rigurosa estructura de orden clásico y un retablo de exquisito gusto. Fue levantada siguiendo los parámetros arquitectónicos clásicos: Por el exterior Dórico y por el interior Corintio. El templo consta de 4 naves y de una fachada principal de especial simetría y elegante estructura. Las imágenes muestran parte de las valiosas pinturas y esculturas que adornan la catedral y que constituye un valioso patrimonio cultural e histórico. El altar de la capilla de Jesús sacramentado y  los muebles que se hallan en ambos lados fueron elaborados por el renombrado arquitecto y ebanista pastuso Lucindo Espinosa')");



        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('TEMPLO DE CRISTO REY', 'http://static.panoramio.com/photos/original/3115787.jpg', 'Cra. 24 #20, Pasto, Nariño','horario lunes a Domingo','descripcion En la fachada del templo, de tipo romano gótico, se evidencian dos torres gemelas que rematan con ángeles, uno en cada vértice, y en el centro se levanta, a 36 metros de altura, la dominante imagen de Cristo Rey rodeada por esculturas que representan a la humanidad. Esta imponente estatuaria corresponde al ingenio y concepción artística del \"Escultor de los Vientos\", el maestro Marceliano Vallejo oriundo del municipio de El Contadero, Nariño. Así mismo, sobresale la enorme escultura externa de San Ignacio de Loyola, elaborada en mármol por el escultor ecuatoriano Eloy A. Campos')");


        db.execSQL("INSERT INTO iglesias (namei, imagen, direction, horarios, descripcion) VALUES" +
                " ('Iglesia de San Agustín', 'https://instanttanne.files.wordpress.com/2016/03/iglesia-san-agustin-pasto.jpg', 'Carrera 24 # 16-70.','horario Horarios Lunes a Sábado: 6:30 a.m. a 8:00 a.m. y 6:00 p.m. a 7:00 p.m. y Domingos: 8:00 a.m. a 10:00 a.m. y 6:00 p.m. a 7:30 a.m.','descripcion: Su estilo conserva tradiciones Románicas con algunas reminiscencias de otros templos ha sido adaptado y construida a cimentaciones modernas. Este templo es relativamente amplio y bien cuidado; es llamado capilla del señor de las caídas, imagen admirable por lo impresionante y antiguo, representa a Cristo con la Cruz a cuestas y recuerda sus siete caídas. Este templo alberga imágenes de la escuela Quiteña del siglo XVIII.')");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_IGLESIAS);
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_FAVORITOS);
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_COMMENTSUSERS);
        onCreate(db);

    }


}


