package py.com.consultoresinformaticos.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author ENRIQUE
 */
public class SendMail {

    final static Logger logger = Logger.getLogger(SendMail.class);
    private static Properties emailProperty;

    public static void sendMail(String to, String subject, String content) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final Properties props = new Properties();
            props.load(classLoader.getResourceAsStream("email.properties"));
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(props.getProperty("user"), props.getProperty("password"));
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("info@consultoresinformaticos.com.py"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));
                message.setSubject(subject);
                message.setContent(content, "text/html");
                Transport.send(message);

                logger.info("Send mail to:" + to + " Subject:" + subject);

            } catch (MessagingException e) {
                logger.error("CLASS SendMail METHOD: SendMail ", e);
            }
        } catch (Exception e) {
            logger.error("CLASS SendMail METHOD: SendMail ", e);

        }

    }
    
    public static void main(String args[]){
        String contenido = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\n" +
"		<!-- NAME: 1 COLUMN -->\n" +
"		<!--[if gte mso 15]>\n" +
"		<xml>\n" +
"			<o:OfficeDocumentSettings>\n" +
"			<o:AllowPNG/>\n" +
"			<o:PixelsPerInch>117</o:PixelsPerInch>\n" +
"			</o:OfficeDocumentSettings>\n" +
"		</xml>\n" +
"		<![endif]-->\n" +
"		<meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"		<title>*|MC:SUBJECT|*</title>\n" +
"        \n" +
"    <style type=\"text/css\">\n" +
"		p{\n" +
"			margin:10px 0;\n" +
"			padding:0;\n" +
"		}\n" +
"		table{\n" +
"			border-collapse:collapse;\n" +
"		}\n" +
"		h1,h2,h3,h4,h5,h6{\n" +
"			display:block;\n" +
"			margin:0;\n" +
"			padding:0;\n" +
"		}\n" +
"		img,a img{\n" +
"			border:0;\n" +
"			height:auto;\n" +
"			outline:none;\n" +
"			text-decoration:none;\n" +
"		}\n" +
"		body,#bodyTable,#bodyCell{\n" +
"			height:100%;\n" +
"			margin:0;\n" +
"			padding:0;\n" +
"			width:100%;\n" +
"		}\n" +
"		#outlook a{\n" +
"			padding:0;\n" +
"		}\n" +
"		img{\n" +
"			-ms-interpolation-mode:bicubic;\n" +
"		}\n" +
"		table{\n" +
"			mso-table-lspace:0pt;\n" +
"			mso-table-rspace:0pt;\n" +
"		}\n" +
"		.ReadMsgBody{\n" +
"			width:100%;\n" +
"		}\n" +
"		.ExternalClass{\n" +
"			width:100%;\n" +
"		}\n" +
"		p,a,li,td,blockquote{\n" +
"			mso-line-height-rule:exactly;\n" +
"		}\n" +
"		a[href^=tel],a[href^=sms]{\n" +
"			color:inherit;\n" +
"			cursor:default;\n" +
"			text-decoration:none;\n" +
"		}\n" +
"		p,a,li,td,body,table,blockquote{\n" +
"			-ms-text-size-adjust:100%;\n" +
"			-webkit-text-size-adjust:100%;\n" +
"		}\n" +
"		.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{\n" +
"			line-height:100%;\n" +
"		}\n" +
"		a[x-apple-data-detectors]{\n" +
"			color:inherit !important;\n" +
"			text-decoration:none !important;\n" +
"			font-size:inherit !important;\n" +
"			font-family:inherit !important;\n" +
"			font-weight:inherit !important;\n" +
"			line-height:inherit !important;\n" +
"		}\n" +
"		#bodyCell{\n" +
"			padding:10px;\n" +
"		}\n" +
"		.templateContainer{\n" +
"			max-width:600px !important;\n" +
"		}\n" +
"		a.mcnButton{\n" +
"			display:block;\n" +
"		}\n" +
"		.mcnImage{\n" +
"			vertical-align:bottom;\n" +
"		}\n" +
"		.mcnTextContent{\n" +
"			word-break:break-word;\n" +
"		}\n" +
"		.mcnTextContent img{\n" +
"			height:auto !important;\n" +
"		}\n" +
"		.mcnDividerBlock{\n" +
"			table-layout:fixed !important;\n" +
"		}\n" +
"		body,#bodyTable{\n" +
"			background-color:#FAFAFA;\n" +
"		}\n" +
"		#bodyCell{\n" +
"			border-top:0;\n" +
"		}\n" +
"		.templateContainer{\n" +
"			border:0;\n" +
"		}\n" +
"		h1{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:26px;\n" +
"			font-style:normal;\n" +
"			font-weight:bold;\n" +
"			line-height:32px;\n" +
"			letter-spacing:normal;\n" +
"			text-align:left;\n" +
"		}\n" +
"		h2{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:22px;\n" +
"			font-style:normal;\n" +
"			font-weight:bold;\n" +
"			line-height:30px;\n" +
"			letter-spacing:normal;\n" +
"			text-align:left;\n" +
"		}\n" +
"		h3{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:20px;\n" +
"			font-style:normal;\n" +
"			font-weight:bold;\n" +
"			line-height:26px;\n" +
"			letter-spacing:normal;\n" +
"			text-align:left;\n" +
"		}\n" +
"		h4{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:18px;\n" +
"			font-style:normal;\n" +
"			font-weight:bold;\n" +
"			line-height:24px;\n" +
"			letter-spacing:normal;\n" +
"			text-align:left;\n" +
"		}\n" +
"		#templatePreheader{\n" +
"			background-color:#FAFAFA;\n" +
"			border-top:0;\n" +
"			border-bottom:0;\n" +
"			padding-top:9px;\n" +
"			padding-bottom:9px;\n" +
"		}\n" +
"		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{\n" +
"			color:#656565;\n" +
"			font-family:Helvetica;\n" +
"			font-size:12px;\n" +
"			line-height:18px;\n" +
"			text-align:left;\n" +
"		}\n" +
"		#templatePreheader .mcnTextContent a,#templatePreheader .mcnTextContent p a{\n" +
"			color:#656565;\n" +
"			font-weight:normal;\n" +
"			text-decoration:underline;\n" +
"		}\n" +
"		#templateHeader{\n" +
"			background-color:#FFFFFF;\n" +
"			border-top:0;\n" +
"			border-bottom:0;\n" +
"			padding-top:9px;\n" +
"			padding-bottom:0;\n" +
"		}\n" +
"		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:16px;\n" +
"			line-height:24px;\n" +
"			text-align:left;\n" +
"		}\n" +
"		#templateHeader .mcnTextContent a,#templateHeader .mcnTextContent p a{\n" +
"			color:#2BAADF;\n" +
"			font-weight:normal;\n" +
"			text-decoration:underline;\n" +
"		}\n" +
"		#templateBody{\n" +
"			background-color:#FFFFFF;\n" +
"			border-top:0;\n" +
"			border-bottom:2px solid #EAEAEA;\n" +
"			padding-top:0;\n" +
"			padding-bottom:9px;\n" +
"		}\n" +
"		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{\n" +
"			color:#202020;\n" +
"			font-family:Helvetica;\n" +
"			font-size:16px;\n" +
"			line-height:24px;\n" +
"			text-align:left;\n" +
"		}\n" +
"		#templateBody .mcnTextContent a,#templateBody .mcnTextContent p a{\n" +
"			color:#2BAADF;\n" +
"			font-weight:normal;\n" +
"			text-decoration:underline;\n" +
"		}\n" +
"		#templateFooter{\n" +
"			background-color:#FAFAFA;\n" +
"			border-top:0;\n" +
"			border-bottom:0;\n" +
"			padding-top:9px;\n" +
"			padding-bottom:9px;\n" +
"		}\n" +
"		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{\n" +
"			color:#656565;\n" +
"			font-family:Helvetica;\n" +
"			font-size:12px;\n" +
"			line-height:18px;\n" +
"			text-align:center;\n" +
"		}\n" +
"		#templateFooter .mcnTextContent a,#templateFooter .mcnTextContent p a{\n" +
"			color:#656565;\n" +
"			font-weight:normal;\n" +
"			text-decoration:underline;\n" +
"		}\n" +
"	@media only screen and (min-width:768px){\n" +
"		.templateContainer{\n" +
"			width:600px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		body,table,td,p,a,li,blockquote{\n" +
"			-webkit-text-size-adjust:none !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		body{\n" +
"			width:100% !important;\n" +
"			min-width:100% !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#bodyCell{\n" +
"			padding-top:10px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImage{\n" +
"			width:100% !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnShareContent,.mcnCaptionTopContent,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{\n" +
"			max-width:100% !important;\n" +
"			width:100% !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnBoxedTextContentContainer{\n" +
"			min-width:100% !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageGroupContent{\n" +
"			padding:9px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{\n" +
"			padding-top:9px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{\n" +
"			padding-top:18px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageCardBottomImageContent{\n" +
"			padding-bottom:9px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageGroupBlockInner{\n" +
"			padding-top:0 !important;\n" +
"			padding-bottom:0 !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageGroupBlockOuter{\n" +
"			padding-top:9px !important;\n" +
"			padding-bottom:9px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnTextContent,.mcnBoxedTextContentColumn{\n" +
"			padding-right:18px !important;\n" +
"			padding-left:18px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{\n" +
"			padding-right:18px !important;\n" +
"			padding-bottom:0 !important;\n" +
"			padding-left:18px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcpreview-image-uploader{\n" +
"			display:none !important;\n" +
"			width:100% !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		h1{\n" +
"			font-size:22px !important;\n" +
"			line-height:28px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		h2{\n" +
"			font-size:20px !important;\n" +
"			line-height:26px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		h3{\n" +
"			font-size:18px !important;\n" +
"			line-height:24px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		h4{\n" +
"			font-size:16px !important;\n" +
"			line-height:22px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{\n" +
"			font-size:14px !important;\n" +
"			line-height:22px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#templatePreheader{\n" +
"			display:block !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{\n" +
"			font-size:14px !important;\n" +
"			line-height:22px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{\n" +
"			font-size:16px !important;\n" +
"			line-height:24px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#templateBody .mcnTextContent,#templateBody .mcnTextContent p{\n" +
"			font-size:16px !important;\n" +
"			line-height:24px !important;\n" +
"		}\n" +
"\n" +
"}	@media only screen and (max-width: 480px){\n" +
"		#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{\n" +
"			font-size:14px !important;\n" +
"			line-height:22px !important;\n" +
"		}\n" +
"\n" +
"}</style></head>\n" +
"    <body style=\"height: 100%;margin: 0;padding: 0;width: 100%;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #FAFAFA;\">\n" +
"        <center>\n" +
"            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"bodyTable\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;height: 100%;margin: 0;padding: 0;width: 100%;background-color: #FAFAFA;\">\n" +
"                <tbody><tr>\n" +
"                    <td align=\"center\" valign=\"top\" id=\"bodyCell\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;height: 100%;margin: 0;padding: 10px;width: 100%;border-top: 0;\">\n" +
"                        <!-- BEGIN TEMPLATE // -->\n" +
"						<!--[if gte mso 9]>\n" +
"						<table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\">\n" +
"						<tr>\n" +
"						<td align=\"center\" valign=\"top\" width=\"600\">\n" +
"						<![endif]-->\n" +
"                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"templateContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;border: 0;max-width: 600px !important;\">\n" +
"                            <tbody><tr>\n" +
"                                <td valign=\"top\" id=\"templatePreheader\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #FAFAFA;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td valign=\"top\" id=\"templateHeader\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #FFFFFF;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 0;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnImageBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"    <tbody class=\"mcnImageBlockOuter\">\n" +
"            <tr>\n" +
"                <td valign=\"top\" style=\"padding: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnImageBlockInner\">\n" +
"                    <table align=\"left\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnImageContentContainer\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                        <tbody><tr>\n" +
"                            <td class=\"mcnImageContent\" valign=\"top\" style=\"padding-right: 9px;padding-left: 9px;padding-top: 0;padding-bottom: 0;text-align: center;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                                \n" +
"                                    \n" +
"                                <img align=\"center\" alt=\"\" src=\"https://gallery.mailchimp.com/403824592d20f035380dc123d/images/84f0bfaf-9c4c-482c-8026-0bdceac5d292.png\" width=\"564\" style=\"max-width: 1500px;padding-bottom: 0;display: inline !important;vertical-align: bottom;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" class=\"mcnImage\"></td>\n" +
"                        </tr>\n" +
"                    </tbody></table>\n" +
"                </td>\n" +
"            </tr>\n" +
"    </tbody>\n" +
"</table></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td valign=\"top\" id=\"templateBody\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #FFFFFF;border-top: 0;border-bottom: 2px solid #EAEAEA;padding-top: 0;padding-bottom: 9px;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnTextBlock\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"    <tbody class=\"mcnTextBlockOuter\">\n" +
"        <tr>\n" +
"            <td valign=\"top\" class=\"mcnTextBlockInner\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                \n" +
"                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" class=\"mcnTextContentContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                    <tbody><tr>\n" +
"                        \n" +
"                        <td valign=\"top\" class=\"mcnTextContent\" style=\"padding-top: 9px;padding-right: 18px;padding-bottom: 9px;padding-left: 18px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;color: #202020;font-family: Helvetica;font-size: 16px;line-height: 24px;text-align: left;\">\n" +
"                        \n" +
"                            <h1 style=\"display: block;margin: 0;padding: 0;color: #202020;font-family: Helvetica;font-size: 26px;font-style: normal;font-weight: bold;line-height: 32px;letter-spacing: normal;text-align: left;\">Estimado/a</h1>\n" +
"\n" +
"<p style=\"margin: 10px 0;padding: 0;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #202020;font-family: Helvetica;font-size: 16px;line-height: 24px;text-align: left;\">Te has inscripto al taller <em><strong>\"CÃ³mo desarrollar aplicaciones Java Web\"</strong></em>, para este curso se pondrÃ¡n a disposiciÃ³n de los alumnos computadoras con lo necesario para llevar a cabo las prÃ¡cticas, sin embargo, puede que la cantidad de computadora supere la cantidad de participante.<br>\n" +
"Si queres&nbsp;utilizar alguno de&nbsp;estos equipo intentÃ¡&nbsp;llegar temprano.<br>\n" +
"<br>\n" +
"En caso de que lleves tu propia computadora te recomedamos instalar los siguientes programas.</p>\n" +
"\n" +
"<ul>\n" +
"	<li style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">Java JDK 1.7&nbsp;</li>\n" +
"	<li style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">Mysql Server 5&nbsp;</li>\n" +
"	<li style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">Netbeans 8.1, el mismo instalador de netbeans ya viene con la versiÃ³n del Glassfish 4.1 la cual utilizaremos durante el taller.</li>\n" +
"	<li style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">Cliente git</li>\n" +
"	<li style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">Android Developer Studio con SDK&nbsp;</li>\n" +
"	</ul>\n" +
"<p>TambiÃ©n deberÃ¡s configurar un dataSource en el servidor de aplicaciones, para ello hemos escrito un pequeÃ±o tutorial al cual podrÃ¡s acceder a travÃ©s de este enlace: <a href=\"http://www.consultoresinformaticos.com.py/blog/como-configurar-un-datasource-en-glassfish/\" target=\"_blank\">CÃ³mo configurar un datasource en Glassfish</a></p>\n" +
"Te esperamos el martes 22 a partir de las 17:45.\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </tbody></table>\n" +
"                \n" +
"            </td>\n" +
"        </tr>\n" +
"    </tbody>\n" +
"</table></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td valign=\"top\" id=\"templateFooter\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;background-color: #FAFAFA;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowBlock\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"    <tbody class=\"mcnFollowBlockOuter\">\n" +
"        <tr>\n" +
"            <td align=\"center\" valign=\"top\" style=\"padding: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowBlockInner\">\n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"    <tbody><tr>\n" +
"        <td align=\"center\" style=\"padding-left: 9px;padding-right: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContent\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                <tbody><tr>\n" +
"                    <td align=\"center\" valign=\"top\" style=\"padding-top: 9px;padding-right: 9px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"						<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"							<tbody><tr>\n" +
"								<td valign=\"top\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                        \n" +
"			                            \n" +
"			                            \n" +
"			                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                    <tbody><tr>\n" +
"			                                        <td valign=\"top\" style=\"padding-right: 10px;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"			                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                <tbody><tr>\n" +
"			                                                    <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                            <tbody><tr>\n" +
"			                                                                \n" +
"			                                                                    <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                                        <a href=\"https://www.facebook.com/Consultores-Inform%C3%A1ticos-107671862676321\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"http://cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"			                                                                    </td>\n" +
"			                                                                \n" +
"			                                                                \n" +
"			                                                            </tr>\n" +
"			                                                        </tbody></table>\n" +
"			                                                    </td>\n" +
"			                                                </tr>\n" +
"			                                            </tbody></table>\n" +
"			                                        </td>\n" +
"			                                    </tr>\n" +
"			                                </tbody></table>\n" +
"			                            \n" +
"			                        \n" +
"			                            \n" +
"			                            \n" +
"			                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                    <tbody><tr>\n" +
"			                                        <td valign=\"top\" style=\"padding-right: 10px;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"			                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                <tbody><tr>\n" +
"			                                                    <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                            <tbody><tr>\n" +
"			                                                                \n" +
"			                                                                    <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                                        <a href=\"mailto:info@consultoresinformaticos.com.py\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"http://cdn-images.mailchimp.com/icons/social-block-v2/color-forwardtofriend-48.png\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"			                                                                    </td>\n" +
"			                                                                \n" +
"			                                                                \n" +
"			                                                            </tr>\n" +
"			                                                        </tbody></table>\n" +
"			                                                    </td>\n" +
"			                                                </tr>\n" +
"			                                            </tbody></table>\n" +
"			                                        </td>\n" +
"			                                    </tr>\n" +
"			                                </tbody></table>\n" +
"			                            \n" +
"			                        \n" +
"			                            \n" +
"			                            \n" +
"			                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                    <tbody><tr>\n" +
"			                                        <td valign=\"top\" style=\"padding-right: 0;padding-bottom: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\" class=\"mcnFollowContentItemContainer\">\n" +
"			                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnFollowContentItem\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                <tbody><tr>\n" +
"			                                                    <td align=\"left\" valign=\"middle\" style=\"padding-top: 5px;padding-right: 10px;padding-bottom: 5px;padding-left: 9px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                        <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                            <tbody><tr>\n" +
"			                                                                \n" +
"			                                                                    <td align=\"center\" valign=\"middle\" width=\"24\" class=\"mcnFollowIconContent\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"			                                                                        <a href=\"https://twitter.com/consultores_py\" target=\"_blank\" style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\"><img src=\"http://cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png\" style=\"display: block;border: 0;height: auto;outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;\" height=\"24\" width=\"24\" class=\"\"></a>\n" +
"			                                                                    </td>\n" +
"			                                                                \n" +
"			                                                                \n" +
"			                                                            </tr>\n" +
"			                                                        </tbody></table>\n" +
"			                                                    </td>\n" +
"			                                                </tr>\n" +
"			                                            </tbody></table>\n" +
"			                                        </td>\n" +
"			                                    </tr>\n" +
"			                                </tbody></table>\n" +
"			                            \n" +
"			                        \n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody></table>\n" +
"                    </td>\n" +
"                </tr>\n" +
"            </tbody></table>\n" +
"        </td>\n" +
"    </tr>\n" +
"</tbody></table>\n" +
"\n" +
"            </td>\n" +
"        </tr>\n" +
"    </tbody>\n" +
"</table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"mcnDividerBlock\" style=\"min-width: 100%;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;table-layout: fixed !important;\">\n" +
"    <tbody class=\"mcnDividerBlockOuter\">\n" +
"        <tr>\n" +
"            <td class=\"mcnDividerBlockInner\" style=\"min-width: 100%;padding: 10px 18px 25px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                <table class=\"mcnDividerContent\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"min-width: 100%;border-top-width: 2px;border-top-style: solid;border-top-color: #EEEEEE;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                    <tbody><tr>\n" +
"                        <td style=\"mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;\">\n" +
"                            <span></span>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </tbody></table>\n" +
"<!--            \n" +
"                <td class=\"mcnDividerBlockInner\" style=\"padding: 18px;\">\n" +
"                <hr class=\"mcnDividerContent\" style=\"border-bottom-color:none; border-left-color:none; border-right-color:none; border-bottom-width:0; border-left-width:0; border-right-width:0; margin-top:0; margin-right:0; margin-bottom:0; margin-left:0;\" />\n" +
"-->\n" +
"            </td>\n" +
"        </tr>\n" +
"    </tbody>\n" +
"</table></td>\n" +
"                            </tr>\n" +
"                        </tbody></table>\n" +
"						<!--[if gte mso 9]>\n" +
"						</td>\n" +
"						</tr>\n" +
"						</table>\n" +
"						<![endif]-->\n" +
"                        <!-- // END TEMPLATE -->\n" +
"                    </td>\n" +
"                </tr>\n" +
"            </tbody></table>\n" +
"        </center>\n" +
"    \n" +
"</body></html>";
        sendMail("erodriguez@consultoresinformaticos.com.py", "ETyC", contenido);
    }

}
