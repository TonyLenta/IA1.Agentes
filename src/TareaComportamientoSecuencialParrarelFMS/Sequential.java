
package TareaComportamientoSecuencialParrarelFMS;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
/**
 *
 * @author tony_
 */
public class Sequential extends Agent {

    protected void setup() {
        SequentialBehaviour sb = new SequentialBehaviour();

        sb.addSubBehaviour(new OneShot("TProceso 1"));
        sb.addSubBehaviour(new OneShot("Proceso 2"));
        sb.addSubBehaviour(new OneShot("Proceso 3"));
        sb.addSubBehaviour(new OneShot("Proceso 4"));
        sb.addSubBehaviour(new OneShot("Proceso 5"));
        addBehaviour(sb);
    }

    private class OneShot extends OneShotBehaviour {

        private String id = "";

        public OneShot(String arg) {
            this.id = arg;
        }

        public void action() {
            System.out.println("Ejecucion de subComportamiento " + id);
        }
    }
}