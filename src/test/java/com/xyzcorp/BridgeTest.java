package com.xyzcorp;

import com.xyzcorp.bridge.MyNode;
import com.xyzcorp.bridge.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    /**
     * The following is an example of a bridge method.
     * When compiled and running javap -p on the Node and MyNode Types you
     * will see a more refined type of the method on MyNode that is created
     * automatically. Run:
     *
     * javap -cp target/classes -p com.xyzcorp.bridge.Node
     * javap -cp target/classes -p com.xyzcorp.bridge.MyNode
     */
    @Test
    public void testBridgeMethod() {
        //base is a raw type, we are emulated what it is at runtime
        Node base = new MyNode(5);
        //Remember that at runtime, type params are erased
        base.setData(40);
        assertThat(base.getData()).isEqualTo(40);
    }
}
