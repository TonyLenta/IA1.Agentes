
package TareaComportamientoSecuencialParrarelFMS;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.FSMBehaviour;
/**
 *
 * @author tony_
 */
public class FMS extends Agent{
   
    
    private static final String STATE_A = "Francisco";
    private static final String STATE_B = "Pedro";
    private static final String STATE_C = "Diana";
    private static final String STATE_D = "Zamanta";
    private static final String STATE_E = "Luis";
    private static final String STATE_F = "Alejandro";
   
    protected void setup() {
        FSMBehaviour fsm = new FSMBehaviour(this) {
            public int onEnd() {
                System.out.println("Comportamiento FMS terminado.");
                myAgent.doDelete();
                return super.onEnd();
            }
        };
       
        // Register state A (first state)
        fsm.registerFirstState(new NamePrinter(), STATE_A);
       
        // Register state B
        fsm.registerState(new NamePrinter(), STATE_B);
       
        // Register state C
        fsm.registerState(new RandomGenerator(3), STATE_C);
       
        // Register state D
        fsm.registerState(new NamePrinter(), STATE_D);
       
        // Register state E
        fsm.registerState(new RandomGenerator(4), STATE_E);
       
        // Register state F (final state)
        fsm.registerLastState(new NamePrinter(), STATE_F);

        // Register the transitions
        fsm.registerDefaultTransition(STATE_A, STATE_B);
        fsm.registerDefaultTransition(STATE_B, STATE_C);
        fsm.registerTransition(STATE_C, STATE_C, 0);
        fsm.registerTransition(STATE_C, STATE_D, 1);
        fsm.registerTransition(STATE_C, STATE_A, 2);
        fsm.registerDefaultTransition(STATE_D, STATE_E);
        fsm.registerTransition(STATE_E, STATE_F, 3);
        fsm.registerDefaultTransition(STATE_E, STATE_B);
       
        addBehaviour(fsm);
    }
   
    
    private class NamePrinter extends OneShotBehaviour {
        public void action() {
            System.out.println("Executing behaviour "+getBehaviourName());
        }
    }
   
    private class RandomGenerator extends NamePrinter {
        private int maxExitValue;
        private int exitValue;
       
        private RandomGenerator(int max) {
            super();
            maxExitValue = max;
        }
       
        public void action() {
            System.out.println("Executing behaviour "+getBehaviourName());
            exitValue = (int) (Math.random() * maxExitValue);
            System.out.println("Exit value is "+exitValue);
        }
       
        public int onEnd() {
            return exitValue;
        }
    }
}

