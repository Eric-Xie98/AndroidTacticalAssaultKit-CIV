
package com.atakmap.android.image.nitf.CGM;

import java.io.DataInput;
import java.io.IOException;

/**
 *
 */
public class LineColourCommand extends Command {
    public int color = -1;
    public int colorIndex = -1;

    public LineColourCommand(int ec, int eid, int l, DataInput in)
            throws IOException {
        super(ec, eid, l, in);
        if (ColourSelectionModeCommand.getType().equals(
                ColourSelectionModeCommand.Type.DIRECT)) {
            this.color = makeDirectColor();
        } else if (ColourSelectionModeCommand.getType().equals(
                ColourSelectionModeCommand.Type.INDEXED)) {
            this.colorIndex = makeColorIndex();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LineColour");
        if (this.color != -1) {
            sb.append(" directColor=").append(this.color);
        } else {
            sb.append(" colorIndex=").append(this.colorIndex);
        }
        return sb.toString();
    }
}
