package Command;
public class scrollBarCommand extends commandCommand {

	public scrollBarCommand(receiverCommand receiverCommand) {
		super(receiverCommand);
	}
	public void execute() {
		receiverCommand.ScrollBar();
	}

}
