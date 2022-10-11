package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.model.internship.InternshipId;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonId;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final Integer DEFAULT_PERSON_ID = 0;
    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";

    private PersonId personId;
    private Name name;
    private Phone phone;
    private Email email;
    private InternshipId internshipId;
    private Set<Tag> tags;
    private Index linkIndex;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        personId = new PersonId(DEFAULT_PERSON_ID);
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        internshipId = null;
        tags = new HashSet<>();
        linkIndex = null;
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        personId = personToCopy.getPersonId();
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        internshipId = personToCopy.getInternshipId();
        tags = new HashSet<>(personToCopy.getTags());
        linkIndex = personToCopy.getLinkIndex();
    }

    /**
     * Sets the {@code PersonId} of the {@code Person} that we are building.
     */
    public PersonBuilder withPersonId(Integer id) {
        this.personId = new PersonId(id);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }


    /**
     * Sets the {@code InternshipId} of the {@code Person} that we are building.
     */
    public PersonBuilder withInternshipId(Integer id) {
        this.internshipId = new InternshipId(id);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code LinkIndex} of the {@code Person} that we are building.
     */
    public PersonBuilder withLinkIndex(Integer index) {
        this.linkIndex = Index.fromZeroBased(index);
        return this;
    }

    public Person build() {
        return new Person(personId, name, phone, email, internshipId, tags, linkIndex);
    }

}
