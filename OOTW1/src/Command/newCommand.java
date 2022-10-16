package Command;
public class newCommand extends commandCommand {

	public newCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.New();
	}

}
