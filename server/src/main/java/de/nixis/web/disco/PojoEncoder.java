package de.nixis.web.disco;

import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;
import de.nixis.web.disco.dto.Base;
import io.netty.buffer.MessageBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 *
 * @author nico.rehwaldt
 */
class PojoEncoder extends MessageToMessageEncoder<Base> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Base msg, MessageBuf<Object> out) throws Exception {

    StringWriter writer = new StringWriter();

    String msgName = msg.getClass().getSimpleName();
    msgName = msgName.substring(0, 1).toLowerCase() + msgName.substring(1);

    writer.append("{ \"").append(msgName).append("\": ");

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(writer, msg);

    writer.append("}");
    
    out.add(new TextWebSocketFrame(writer.toString()));
  }
}
