public class CheckedState implements State{

    @Override
    public void update(StateChain stateChain) {
        stateChain.set_state(new UncheckedState());          // new state will be unchecked state
        stateChain.setName("Unchecked");
    }
}

