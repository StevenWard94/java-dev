/**
 * Steven Ward
 * DomainName.java | Domain Name Project
 *
 * This file contains the definition for the DomainName class, which is described below.
 *
 * Due Date: September 18, 2016
 *
 */

/**
 * DomainName class that encapsulates the concept of a single-attribute domain name.
 * The 'DomainName' class acts as a "wrapper" object for a domain name. In this context, a domain
 * name is considered to be a URL consisting of an optional "www", a name (e.g. "google"), and an
 * extension (e.g. "com" or "org"), separated by a "dot" ('.'). The class also provides member
 * functions to access the 'domain' field (accessor and mutator) as well as three functions to get
 * the three components of a domain name, which were listed previously.
 */
public class DomainName {
  /** The single member variable of the 'DomainName' class: 'domain', a String variable containing
   * the entire domain name */
  private String domain;

  /**
   * Constructor for the 'DomainName' class.
   * This is the only constructor for the 'DomainName' class, as there is no explicitly-defined
   * default constructor. The constructor accepts a single argument: a String variable containing
   * the domain name to be stored in the newly constructed 'DomainName' instance. The new instance's
   * 'domain' field is set to the value of the argument with which the constructor was called.
   *
   * @param domain_  A String containing the new instance's domain name.
   */
  public DomainName(String domain_) {
    domain = domain_;
  }

  /**
   * Accessor method for the 'domain' field member.
   * This function is a simple accessor method to return the value stored in a class instance's
   * private 'domain' member field. It takes no arguments and returns a String value equivalent
   * to the calling instance's 'domain' field.
   *
   * @return The 'domain' as a String.
   */
  public String getDomain( ) {
    return this.domain;
  }

  /**
   * Mutator method for the 'domain' field member.
   * This function is a simple mutator method to set the value of a class instance's private
   * 'domain' member field. It takes a single, String argument, which is the desired value of the
   * calling instance's 'domain' field, and does not return a value.
   *
   * @param domain_  The new 'domain' String.
   */
  public void setDomain(String domain_) {
    this.domain = domain_;
  }

  /**
   * Method returning whether or not the domain name starts with "www".
   * This method returns a boolean value based on the presence of "www" as the first element of
   * a class instance's 'domain' member field: 'true' if the domain name starts with "www.";
   * otherwise, 'false'.
   *
   * @return A boolean value representing the presence of "www." at the start of a domain name.
   */
  public boolean hasPrefix( ) {
    return this.domain.startsWith("www.");
  }

  /**
   * Method returning the domain name's extenstion.
   * This method returns a substring of an instance's 'domain' field containing the characters
   * following the final "dot" ('.'). For example, if an instance's 'domain' field contained
   * "www.google.com", then 'instance.extension()' would return "com". If the final "dot" cannot be
   * found in an instance's 'domain' field, the method returns "unknown".
   *
   * @return A String equivalent to the domain name's extension.
   */
  public String extension( ) {
    int dotIndex = this.domain.lastIndexOf(".");
    if ( dotIndex != -1 && !this.domain.substring(0,dotIndex).equalsIgnoreCase("www") ) {
      return this.domain.substring(dotIndex + 1);
    }
    else {
      return "unknown";
    }
  }

  /**
   * Method returning the domain's "name" itself.
   * This method returns a substring of an instance's 'domain' field containing the characters
   * between the first and second "dots" ('.') of the full domain name. For example, if an
   * instance's 'domain' field contained "www.google.com", then 'instance.name()' would return
   * "google". If there are fewer than two "dots" in the 'domain' String, then the method returns
   * "unknown".
   *
   * @return A String equivalent to the domain's "name", contained between the two "dots".
   */
  public String name() {
    String[] chunks = this.domain.split(".");
    if (chunks.length < 3) {
      return "unknown";
    }
    else {
      return chunks[1];
    }
  }
}
