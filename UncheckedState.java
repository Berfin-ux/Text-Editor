public class UncheckedState implements State{

    @Override
    public void update(StateChain stateChain) {
        stateChain.set_state(new CheckedState());          // new state will be checked state
        stateChain.setName("Checked");
    }
}

