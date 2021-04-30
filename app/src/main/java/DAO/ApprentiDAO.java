package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Métier.Apprenti;

public class ApprentiDAO extends DAO<Apprenti> {

    private SQLiteVisitesApprentis dbVisiteApprenti;
    private SQLiteDatabase db;

    //déclaration des outils nécessaire à la base
    private static final String TABLE_APPRENTI = "APPRENTI";
    private static final String COL_ID_APPRENTI = "IDAPPRENTI";
    private static final String COL_NOMAPPRENTI = "NOMAPPRENTI";
    private static final String COL_PRENOMAPPRENTI = "PRENOMAPPRENT";
    private static final String COL_ADRESSEAPPRENTI = "ADRESSEAPPRENTI";
    private static final String COL_VILLEAPPRENTI = "VILLEAPPRENTI";
    private static final String COL_CPAPPRENTI = "CPAPPRENTI";
    private static final String COL_TELAPPRENTI = "TELAPPRENTI";
    private static final Date COL_DATEDEBUTAPPRENTI = "DATEDEBUTAPPRENTI";
    private static final String COL_CLASSEAPPRENTI = "CLASSEAPPRENTI";
    private static final String COL_MAILAPPRENTI = "MAILAPPRENTI";

    public ApprentiDAO(Context context){dbVisiteApprenti = new SQLiteVisitesApprentis(context);}

    public void open(){db = dbVisiteApprenti.getWritableDatabase();}

    public void close(){db.close();}

    public void insert(Apprenti app){
        ContentValues valeur = new ContentValues();
        valeur.put(COL_ID_APPRENTI, app.getIdApprenti());
        valeur.put(COL_NOMAPPRENTI, app.getNomApp());
        valeur.put(COL_PRENOMAPPRENTI, app.getPrenomApp());
        valeur.put(COL_ADRESSEAPPRENTI, app.getAdresseApp());
        valeur.put(COL_VILLEAPPRENTI, app.getVilleApp());
        valeur.put(COL_CPAPPRENTI, app.getClasseApp());
        valeur.put(COL_TELAPPRENTI, app.getTelApp());
        valeur.put(COL_DATEDEBUTAPPRENTI, app.getDateDebutApp());
        valeur.put(COL_CLASSEAPPRENTI, app.getClasseApp());
        valeur.put(COL_MAILAPPRENTI, app.getMailApp());

        db.insert(TABLE_APPRENTI, null, valeur);
    }
    //insertion de l'apprenti dans la base

    public void update(Apprenti app){
        ContentValues valeur = new ContentValues();
        String clauseWhere = new String();
        db.update(app.getNomApp(),valeur, clauseWhere, null);
    }
    //modification de l'apprenti

    public void delete(Apprenti app){
        String clauseWhere = new String();
        db.delete(app.getNomApp(), clauseWhere, null);
    }
    //suppression de l'apprenti en fonction de son numero

    public Apprenti read(long id){
        String nomTable = TABLE_APPRENTI;
        String selection = "COL_ID_APPRENTI = id";
        String nom;
        String prenom;
        String adresse;
        String ville;
        String cp;
        String tel;
        Date date;
        String classe;
        String mail;
        int idApp;

        Cursor curseurQuery = db.query(nomTable, null, selection, null, null, null, null);
            curseurQuery.moveToFirst();
            idApp = curseurQuery.getInt(1);
            nom = curseurQuery.getString(2);
            prenom = curseurQuery.getString(3);
            adresse = curseurQuery.getString(4);
            ville = curseurQuery.getString(5);
            cp = curseurQuery.getString(6);
            tel = curseurQuery.getString(7);
            date = curseurQuery.getDate(8);
            classe = curseurQuery.getString( 9);
            mail = curseurQuery.getString(10);
            Apprenti unApp = new Apprenti((nom, prenom, adresse, ville, cp, tel, date, classe, mail);
        curseurQuery.close();
        return (unApp);
    }
    //recherche le numéro de l'apprenti dans la base et la retourne

    public ArrayList<Apprenti> read(){
        String nomTable = TABLE_APPRENTI;
        List<Apprenti> desApprentis = new ArrayList<Apprenti>();
        String nom;
        String prenom;
        String adresse;
        String ville;
        String cp;
        String tel;
        Date date;
        String classe;
        String mail;
        int idApp;
        boolean verif;

        Cursor curseur db.query(nomTable, null, null, null, null, null, null);
            curseur.moveToFirst();
            for(int i =0; i < curseur.getCount(); i++){
                idApp = curseur.getInt(0);
                nom = curseur.getString(1);
                prenom = curseur.getString(3);
                adresse = curseur.getString(4);
                ville = curseur.getString(5);
                cp = curseur.getString(6);
                tel = curseur.getString(7);
                date = curseur.getDate(8);
                classe = curseur.getString( 9);
                mail = curseur.getString(10);
                Apprenti unApp = new Apprenti(idApp, nom, prenom, adresse, ville, cp, tel, date, classe, mail);
            }
        return (ArrayList<Apprenti>) desApprentis;
    }
    //retourne la liste de toutes les apprentits enregistrées dans la base
}
