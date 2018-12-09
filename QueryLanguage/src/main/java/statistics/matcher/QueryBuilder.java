/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author Harri
 */
public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher apu = matcher;
        
        return apu;
    }

    public QueryBuilder playsIn(String team) {

        matcher = new And(matcher, new PlaysIn(team));

        return this;
    }

    public QueryBuilder hasAtLeast(int value, String field) {

        matcher = new And(matcher, new HasAtLeast(value, field));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String field) {

        matcher = new And(matcher, new HasFewerThan(value, field));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {

        matcher = new Or(matchers);
        return this;
    }

}
