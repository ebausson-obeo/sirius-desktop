/*******************************************************************************
 * Copyright (c) 2010, 2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tests.swtbot.sequence;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.sirius.diagram.sequence.business.internal.layout.LayoutConstants;
import org.eclipse.sirius.diagram.sequence.ui.tool.internal.edit.part.SequenceMessageEditPart;
import org.eclipse.sirius.tests.swtbot.sequence.condition.CheckNotEmptySelection;
import org.eclipse.sirius.tests.swtbot.sequence.condition.CheckReturnMessageNumber;
import org.eclipse.sirius.tests.unit.diagram.sequence.InteractionsConstants;

/**
 * Test class for creation message management
 * 
 * @author smonnier
 */
public class SequenceExecutionBasicAndReturnMessageTest extends AbstractDefaultModelSequenceTests {

    private SequenceMessageEditPart firstReturnMessage;

    private SequenceMessageEditPart thirdReturnMessage;

    private SequenceMessageEditPart secondReturnMessage;

    private int m1y;

    private int return1yClic;

    private int execA0yClic;

    private Rectangle execA0;

    private Rectangle execA1;

    private int m3y;

    private int m4y;

    private int return2yClic;

    private int return3yClic;

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Creation_Ordering() throws Exception {
        // Go to the origin to avoid scroll bar. Indeed, there is sometimes,
        // without understanding why, scroll bar in this test, and this makes
        // fail the test.
        editor.scrollTo(0, 0);

        m1y = 150;
        return1yClic = 400;
        execA0yClic = 200;

        // Reveal A to scroll to the left
        editor.reveal(LIFELINE_A);

        // Calculate the X position of the center of lifelines A and B
        int lifelineAPosition = getLifelineScreenX(LIFELINE_A);
        int lifelineBPosition = getLifelineScreenX(LIFELINE_B);

        // Creation of a message
        createMessage(InteractionsConstants.READ_TOOL_ID, lifelineAPosition, m1y, lifelineBPosition, 300);

        // Validates the position
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);

        // Creation of a return message
        CheckReturnMessageNumber checker = CheckReturnMessageNumber.createIncrementChecker(editor);
        createMessage(InteractionsConstants.RETURN_TOOL_ID, lifelineAPosition, return1yClic, lifelineBPosition, 300);
        bot.waitUntil(checker);
        editor.click(lifelineAPosition + 25, return1yClic);
        bot.waitUntil(new CheckNotEmptySelection(editor, SequenceMessageEditPart.class));
        firstReturnMessage = getSelectedMessage();
        editor.scrollTo(0, 0);
        editor.click(0, 0);

        // Validates the position
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Creation of an execution
        createExecution(lifelineAPosition, execA0yClic);
        // expected bounds with pcd algo
        Rectangle expectedBounds = new Rectangle(0, execA0yClic, 0, return1yClic - LayoutConstants.EXECUTION_CHILDREN_MARGIN - execA0yClic);

        // Validates the position
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, expectedBounds, false);
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Creation of an execution
        createExecution(lifelineAPosition, execA0.getCenter().y);
        Rectangle expectedBounds2 = new Rectangle(0, execA0.getCenter().y, 0, execA0.height / 2 - LayoutConstants.EXECUTION_CHILDREN_MARGIN);

        // Validates the position
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, expectedBounds2, false);
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Creation of a read message from main execution
        m3y = execA0.y + LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP;
        createMessage(InteractionsConstants.READ_TOOL_ID, lifelineAPosition, m3y, lifelineBPosition, 300);

        // Validates the position
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);

        // Creation of a read message to main execution
        m4y = execA0.y + LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP * 2;
        createMessage(InteractionsConstants.READ_TOOL_ID, lifelineBPosition, m4y, lifelineAPosition, 300);

        // Validates the position
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);

        // Creation of a return message from sub execution
        checker = CheckReturnMessageNumber.createIncrementChecker(editor);
        return2yClic = execA1.y + LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP;
        createMessage(InteractionsConstants.RETURN_TOOL_ID, execA1.x, return2yClic, lifelineBPosition, 300);
        bot.waitUntil(checker);
        editor.click(execA1.x + 25, return2yClic);
        bot.waitUntil(new CheckNotEmptySelection(editor, SequenceMessageEditPart.class));
        secondReturnMessage = getSelectedMessage();
        editor.click(0, 0);

        // Validates the position
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);

        // Creation of a return message to sub execution
        checker = CheckReturnMessageNumber.createIncrementChecker(editor);
        return3yClic = execA1.y + LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP * 2;
        createMessage(InteractionsConstants.RETURN_TOOL_ID, lifelineBPosition, return3yClic, execA1.x, return3yClic);
        bot.waitUntil(checker);
        editor.click(execA1.x + 25, return3yClic);
        bot.waitUntil(new CheckNotEmptySelection(editor, SequenceMessageEditPart.class));
        thirdReturnMessage = getSelectedMessage();
        editor.click(0, 0);

        // Validates the position of the executions
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, expectedBounds2, false);

        // Validates the position of the messages
        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);

        validateOrdering(16);
    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Deletion_Ordering() throws Exception {
        test_Creation_Ordering();

        Rectangle e1Bounds = getExecutionScreenBounds(LIFELINE_A, 0);
        Rectangle e2Bounds = getExecutionScreenBounds(LIFELINE_A, 1);

        Point m1 = getSequenceMessageFirstBendpointScreenPosition(FIRST_MESSAGE);
        Point m3 = getSequenceMessageFirstBendpointScreenPosition(THIRD_MESSAGE);
        Point m4 = getSequenceMessageFirstBendpointScreenPosition(FOURTH_MESSAGE);

        Point return1 = getSequenceMessageFirstBendpointScreenPosition(firstReturnMessage);
        Point return2 = getSequenceMessageFirstBendpointScreenPosition(secondReturnMessage);
        Point return3 = getSequenceMessageFirstBendpointScreenPosition(thirdReturnMessage);

        // delete e1 -> reconnect e2 and messages at the same position
        // Deletion of the executions
        editor.click(e1Bounds.getLocation());
        bot.menu("Edit").menu("Delete").click();

        // Click on the diagram to unfocus the created element
        editor.click(0, 0);

        // Check stability
        assertExecutionDoesNotExist(LIFELINE_A, 1);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e2Bounds, false);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2.y);
        assertMessageVerticalPosition(thirdReturnMessage, return3.y);
        assertMessageVerticalPosition(firstReturnMessage, return1.y);

        undo(localSession.getOpenedSession());

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, e2Bounds);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2.y);
        assertMessageVerticalPosition(thirdReturnMessage, return3.y);
        assertMessageVerticalPosition(firstReturnMessage, return1.y);

        redo(localSession.getOpenedSession());

        // Check stability
        assertExecutionDoesNotExist(LIFELINE_A, 1);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e2Bounds, false);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2.y);
        assertMessageVerticalPosition(thirdReturnMessage, return3.y);
        assertMessageVerticalPosition(firstReturnMessage, return1.y);

    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Move() throws Exception {
        maximizeEditor(editor);

        test_Creation_Ordering();

        Rectangle e1Bounds = getExecutionScreenBounds(LIFELINE_A, 0);
        Rectangle e2Bounds = getExecutionScreenBounds(LIFELINE_A, 1);

        Point m1 = getSequenceMessageFirstBendpointScreenPosition(FIRST_MESSAGE);
        Point m3 = getSequenceMessageFirstBendpointScreenPosition(THIRD_MESSAGE);
        Point m4 = getSequenceMessageFirstBendpointScreenPosition(FOURTH_MESSAGE);

        // Move m1 up
        editor.drag(m1.getTranslated(50, 0), m1.getTranslated(50, -10));
        m1.y -= 10;

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Move m1 down
        editor.drag(m1.getTranslated(50, 0), m1.getTranslated(50, +10));
        m1.y += 10;

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Move m1 on e1
        editor.drag(m1.getTranslated(50, 0), e1Bounds.getCenter().getTranslated(0, -10));
        m1.y = e1Bounds.getCenter().y - 10;

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        validateOrdering();

        // Move m1 on e2
        editor.drag(m1.getTranslated(50, 0), e2Bounds.getCenter().getTranslated(0, +10));
        m1.y = e2Bounds.getCenter().y + 10;

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, e2Bounds);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        validateOrdering();

        // Move m1 after e2
        editor.drag(m1.getTranslated(50, 0), e2Bounds.getBottom().getTranslated(0, +LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP * 2));
        m1.y = e2Bounds.getBottom().y + LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP * 2;

        // Check stability
        execA0 = assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        execA1 = assertExecutionHasValidScreenBounds(LIFELINE_A, 1, e2Bounds);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        m1y = m1.y;
        m3y = m3.y;
        m4y = m4.y;

        validateOrdering();

        // Move m1 before e1
        editor.drag(m1.getTranslated(50, 0), e1Bounds.getTop().getTranslated(0, -10));
        m1.y = e1Bounds.getTop().y - 10;

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, e2Bounds);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        validateOrdering();
    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Move_Out_Of_Lifeline() throws Exception {
        maximizeEditor(editor);

        test_Creation_Ordering();

        Point m1 = getSequenceMessageFirstBendpointScreenPosition(FIRST_MESSAGE);
        Point m3 = getSequenceMessageFirstBendpointScreenPosition(THIRD_MESSAGE);
        Point m4 = getSequenceMessageFirstBendpointScreenPosition(FOURTH_MESSAGE);

        // Impossible to move a message before lifeline start
        editor.drag(m1.getTranslated(50, 0), m1.getTranslated(50, -300));

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        editor.drag(m1.getTranslated(50, 0).x, m1y, m1.x, m1.y);

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        // Impossible move a message after a lifeline end
        editor.drag(m1.getTranslated(50, 0), m1.getTranslated(50, +1000));

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        validateOrdering();
    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Undo_Redo_Move() throws Exception {
        test_Move();

        Rectangle e1Bounds = getExecutionScreenBounds(LIFELINE_A, 0);
        Rectangle e2Bounds = getExecutionScreenBounds(LIFELINE_A, 1);

        Point m1 = getSequenceMessageFirstBendpointScreenPosition(FIRST_MESSAGE);
        Point m3 = getSequenceMessageFirstBendpointScreenPosition(THIRD_MESSAGE);
        Point m4 = getSequenceMessageFirstBendpointScreenPosition(FOURTH_MESSAGE);

        Point return1 = getSequenceMessageFirstBendpointScreenPosition(firstReturnMessage);
        Point return2 = getSequenceMessageFirstBendpointScreenPosition(secondReturnMessage);
        Point return3 = getSequenceMessageFirstBendpointScreenPosition(thirdReturnMessage);

        undo(localSession.getOpenedSession());

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        redo(localSession.getOpenedSession());

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, e1Bounds);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, e2Bounds);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1.y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3.y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4.y);
        assertMessageVerticalPosition(secondReturnMessage, return2.y);
        assertMessageVerticalPosition(thirdReturnMessage, return3.y);
        assertMessageVerticalPosition(firstReturnMessage, return1.y);
    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Arrange_All() throws Exception {
        maximizeEditor(editor);

        test_Creation_Ordering();

        arrangeAll();

        assertArrangeAllOk();
    }

    /**
     * 
     */
    private void assertArrangeAllOk() {
        int m1y = getLogicalPosition(LIFELINE_A).y + getLogicalSize(LIFELINE_A).height + LayoutConstants.TIME_START_OFFSET;
        int vGap = LayoutConstants.MIN_INTER_SEQUENCE_EVENTS_VERTICAL_GAP;
        int e1y = m1y + vGap;
        int m3y = e1y + vGap;
        int m4y = m3y + vGap;
        int e2y = m4y + vGap;
        int return2y = e2y + vGap;
        int return3y = return2y + vGap;
        int e2ye = return3y + vGap;
        int e1ye = e2ye + vGap;
        int return1y = e1ye + vGap;

        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, new Rectangle(0, e1y, 0, e1ye - e1y), false);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, new Rectangle(0, e2y, 0, e2ye - e2y), false);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2y);
        assertMessageVerticalPosition(thirdReturnMessage, return3y);
        assertMessageVerticalPosition(firstReturnMessage, return1y);
    }

    /**
     * Test method.
     * 
     * @throws Exception
     *             Test error.
     */
    public void test_Undo_Redo_Arrange_All() throws Exception {
        test_Arrange_All();

        undo(localSession.getOpenedSession());

        // Check stability
        assertExecutionHasValidScreenBounds(LIFELINE_A, 0, execA0);
        assertExecutionHasValidScreenBounds(LIFELINE_A, 1, execA1);

        assertMessageVerticalPosition(FIRST_MESSAGE, m1y);
        assertMessageVerticalPosition(THIRD_MESSAGE, m3y);
        assertMessageVerticalPosition(FOURTH_MESSAGE, m4y);
        assertMessageVerticalPosition(secondReturnMessage, return2yClic);
        assertMessageVerticalPosition(thirdReturnMessage, return3yClic);
        assertMessageVerticalPosition(firstReturnMessage, return1yClic);

        redo(localSession.getOpenedSession());

        assertArrangeAllOk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void tearDown() throws Exception {
        firstReturnMessage = null;
        secondReturnMessage = null;
        thirdReturnMessage = null;
        super.tearDown();
    }
}
