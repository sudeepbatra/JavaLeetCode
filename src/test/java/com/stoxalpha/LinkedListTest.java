package com.stoxalpha;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void removeDuplicates() {
        LinkedList linkedListRemoveDuplicates = new LinkedList();
        linkedListRemoveDuplicates.addLast(1);
        linkedListRemoveDuplicates.addLast(2);
        linkedListRemoveDuplicates.addLast(1);

        linkedListRemoveDuplicates.removeDuplicates();
        Assert.assertEquals(2, linkedListRemoveDuplicates.size());
    }
}
