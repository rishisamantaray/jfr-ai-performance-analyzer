package in.jfr.jfranalyzer.util;

import java.util.List;

public class MarkdownBuilder {

    private final StringBuilder builder = new StringBuilder();

    public MarkdownBuilder heading1(String text) {

        builder.append("# ")
                .append(text)
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder heading2(String text) {

        builder.append("## ")
                .append(text)
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder heading3(String text) {

        builder.append("### ")
                .append(text)
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder paragraph(String text) {

        builder.append(text)
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder separator() {

        builder.append("---")
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder bullet(String text) {

        builder.append("- ")
                .append(text)
                .append("\n");

        return this;
    }

    public MarkdownBuilder codeBlock(String language, String code) {

        builder.append("```")
                .append(language)
                .append("\n");

        builder.append(code);

        builder.append("\n```")
                .append("\n\n");

        return this;
    }

    public MarkdownBuilder table(
            List<String> headers,
            List<List<String>> rows) {

        // Header
        builder.append("|");

        for (String header : headers) {

            builder.append(" ")
                    .append(header)
                    .append(" |");

        }

        builder.append("\n");

        // Separator
        builder.append("|");

        for (int i = 0; i < headers.size(); i++) {

            builder.append(" --- |");

        }

        builder.append("\n");

        // Data
        for (List<String> row : rows) {

            builder.append("|");

            for (String value : row) {

                builder.append(" ")
                        .append(value)
                        .append(" |");

            }

            builder.append("\n");

        }

        builder.append("\n");

        return this;

    }

    public String build() {

        return builder.toString();

    }
}
