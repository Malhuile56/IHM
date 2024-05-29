import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * Controleur du clavier
 */
public class ControleurLettres implements EventHandler<ActionEvent> {

    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    /**
     * vue du jeu
     */
    private Pendu vuePendu;

    /**
     * @param modelePendu modèle du jeu
     * @param vuePendu vue du jeu
     */
    ControleurLettres(MotMystere modelePendu, Pendu vuePendu){
        // A implémenter
        this.modelePendu = modelePendu;
        this.vuePendu = vuePendu;
    }

    /**
     * Actions à effectuer lors du clic sur une touche du clavier
     * Il faut donc: Essayer la lettre, mettre à jour l'affichage et vérifier si la partie est finie
     * @param actionEvent l'événement
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // A implémenter
        Button button = (Button) actionEvent.getSource();
        String letter = button.getText().toUpperCase();
        int occurrences = modelePendu.essaiLettre(letter.charAt(0));
        vuePendu.updateDisplay(modelePendu.getMotCrypte(), modelePendu.getNbErreursRestants(), modelePendu.getLettresEssayees());

        if (modelePendu.gagne()) { popUpMessageGagne(); } 
        else if (modelePendu.perdu()) { popUpMessagePerdu(); }
        
    }
}
