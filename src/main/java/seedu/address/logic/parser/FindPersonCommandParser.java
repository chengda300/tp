package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Arrays;

import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindPersonCommandParser implements Parser<FindPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindPersonCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                        args,
                        PREFIX_NAME,
                        PREFIX_EMAIL,
                        PREFIX_PHONE,
                        PREFIX_TAG);

        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
        }

        String nameArgs = argMultimap.getValue(PREFIX_NAME).orElse("");
        String trimmedNameArgs = nameArgs.trim();
        String[] nameKeywords;
        if (trimmedNameArgs.isEmpty()) {
            nameKeywords = new String[]{};
        } else {
            nameKeywords = trimmedNameArgs.split("\\s+");
        }

        String phoneArgs = argMultimap.getValue(PREFIX_PHONE).orElse("");
        String trimmedPhoneArgs = phoneArgs.trim();
        String[] phoneKeywords;
        if (trimmedPhoneArgs.isEmpty()) {
            phoneKeywords = new String[]{};
        } else {
            phoneKeywords = trimmedPhoneArgs.split("\\s+");
        }

        String emailArgs = argMultimap.getValue(PREFIX_EMAIL).orElse("");
        String trimmedEmailArgs = emailArgs.trim();
        String[] emailKeywords;
        if (trimmedEmailArgs.isEmpty()) {
            emailKeywords = new String[]{};
        } else {
            emailKeywords = trimmedEmailArgs.split("\\s+");
        }

        String tagArgs = argMultimap.getValue(PREFIX_TAG).orElse("");
        String trimmedTagArgs = tagArgs.trim();
        String[] tagKeywords;
        if (trimmedTagArgs.isEmpty()) {
            tagKeywords = new String[]{};
        } else {
            tagKeywords = trimmedTagArgs.split("\\s+");
        }

        return new FindPersonCommand(new PersonContainsKeywordsPredicate(
                Arrays.asList(nameKeywords),
                Arrays.asList(phoneKeywords),
                Arrays.asList(emailKeywords),
                Arrays.asList(tagKeywords)));
    }

}
