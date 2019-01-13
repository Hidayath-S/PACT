package se.ff.bsv.verifyer;
import au.com.dius.pact.model.Interaction;
import au.com.dius.pact.model.PactSource;
import au.com.dius.pact.provider.ProviderVerifier;

import java.util.function.BiConsumer;


public interface NewTarget {
	void testInteraction(String consumer, Interaction interaction, PactSource source);

    /**
     * Add a callback to receive the test interaction result
     */
    void addResultCallback(BiConsumer<Boolean, ProviderVerifier> callback);

}
