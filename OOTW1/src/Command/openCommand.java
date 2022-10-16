package Command;
public class openCommand extends commandCommand {

	public openCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.Open();
	}

}
