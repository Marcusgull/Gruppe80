package lagring;

import javafx.stage.Stage;
import modeller.Arbeidsgiver;
import modeller.Jobbsoker;
import modeller.LedigeVikariater;

import java.io.*;
import java.util.ArrayList;


public abstract class   FileSaveStrategy {
    abstract void lagre (Stage stage, Object obj);
    public static ArrayList<Object> objList = new ArrayList<>();
    public static ArrayList<Object> lagrede;
    public static Object redig = null;

    public void LagreInnholdTilFil(File fil, Object obj) {
        try {
            FileWriter fw = new FileWriter(fil, true);

            if (obj instanceof Arbeidsgiver) {
                String A = "Arbeidsgiver";
                Arbeidsgiver a = (Arbeidsgiver) obj;
                String join = String.join(";"
                        , A
                        , a.data().getAdresse()
                        , a.data().getBransje()
                        , a.data().getEmail()
                        , a.data().getTlf() + "\n");
                fw.append(join);
            } else if (obj instanceof Jobbsoker) {
                Jobbsoker j = (Jobbsoker) obj;
                String J = "Jobbsøker";
                String join = String.join(";"
                        , J
                        , j.data().getEnavn()
                        , j.data().getFnavn()
                        , j.data().getTlf()
                        , j.data().getEmail()
                        , j.data().getAlder()
                        , j.data().getJobbKat()
                        , j.data().getLønnKrav()
                        , j.data().getErfaring()
                        , j.data().getRef() + "\n");
                fw.append(join);
            } else if (obj instanceof LedigeVikariater) {
                LedigeVikariater LV = (LedigeVikariater) obj;
                String lv = "Ledige Vikariater";
                String join = String.join(";"
                        , lv
                        , LV.data().getSektor()
                        , LV.data().getSted()
                        , LV.data().getArbeidsgiver()
                        , LV.data().getJobbkategori()
                        , LV.data().getVarighet()
                        , LV.data().getArbeidstid()
                        , LV.data().getStillingstype()
                        , LV.data().getKvalifikasjoner() + "\n");
                fw.append(join);
            }

            fw.close();
        } catch (IOException e) {
            System.out.println("en error");
        }
    }
    public void Serialisering(File fil, Object object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fil);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            if(object instanceof Arbeidsgiver){
                Arbeidsgiver a = (Arbeidsgiver) object;
                objectOutputStream.writeObject(a);
                objectOutputStream.writeChars(a.data().getAdresse());
                objectOutputStream.writeChars(a.data().getBransje());
                objectOutputStream.writeChars((a.data().getEmail()));
                objectOutputStream.writeChars(a.data().getTlf());
            }

            //metode for serialisering av objekt
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Objektet er serialisert");
    }

    public void Deserialisering(){
        Object object = null;
        String file ="file.ser";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //metode for deserialisering av objekt
            object = objectInputStream.readObject();
            if(object instanceof Arbeidsgiver){
                ((Arbeidsgiver) object).Adresse.setValue(objectInputStream.readUTF());
                ((Arbeidsgiver) object).Bransje.setValue(objectInputStream.readUTF());
                ((Arbeidsgiver) object).Email.setValue(objectInputStream.readUTF());
                ((Arbeidsgiver) object).Tlf.setValue(objectInputStream.readUTF());
            }
        }
        catch (IOException ioe){
            System.out.println("IOEXCEPTION");
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("fant ikke fil");
        }
        System.out.println("deserialisert");
        FileSaveStrategy.objList.add(object);
    }
}