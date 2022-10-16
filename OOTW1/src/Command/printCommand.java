package Command;
public class printCommand extends commandCommand {

	public printCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Print();
	}

}

