import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectStructureGenerator {

    public static void main(String[] args) {
        String basePath = "ai-knowledge-transfer-buddy";

        // All paths (directories or files)
        String[] structure = {
            "src/main/java/com/aiknowledge/buddy/AiKnowledgeTransferBuddyApplication.java",

            "src/main/java/com/aiknowledge/buddy/config/SecurityConfig.java",
            "src/main/java/com/aiknowledge/buddy/config/WebConfig.java",

            "src/main/java/com/aiknowledge/buddy/controller/AuthController.java",
            "src/main/java/com/aiknowledge/buddy/controller/CodeAnalysisController.java",
            "src/main/java/com/aiknowledge/buddy/controller/DocumentationController.java",
            "src/main/java/com/aiknowledge/buddy/controller/GitHubController.java",
            "src/main/java/com/aiknowledge/buddy/controller/JiraController.java",
            "src/main/java/com/aiknowledge/buddy/controller/KnowledgeBaseController.java",
            "src/main/java/com/aiknowledge/buddy/controller/QAController.java",

            "src/main/java/com/aiknowledge/buddy/dto/CommitDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/DocumentationDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/GitHubUserDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/JiraTicketDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/KnowledgeEntryDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/PullRequestDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/QARequestDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/QAResponseDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/SearchRequestDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/SearchResponseDto.java",
            "src/main/java/com/aiknowledge/buddy/dto/SummaryDto.java",

            "src/main/java/com/aiknowledge/buddy/repository/CommitRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/DocumentationRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/JiraTicketRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/KnowledgeEntryRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/PullRequestRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/SummaryRepository.java",
            "src/main/java/com/aiknowledge/buddy/repository/UserRepository.java",

            "src/main/java/com/aiknowledge/buddy/service/AuthService.java",
            "src/main/java/com/aiknowledge/buddy/service/ClaudeService.java",
            "src/main/java/com/aiknowledge/buddy/service/CodeAnalysisService.java",
            "src/main/java/com/aiknowledge/buddy/service/DocumentationService.java",
            "src/main/java/com/aiknowledge/buddy/service/GitHubService.java",
            "src/main/java/com/aiknowledge/buddy/service/JiraService.java",
            "src/main/java/com/aiknowledge/buddy/service/KnowledgeExtractionService.java",
            "src/main/java/com/aiknowledge/buddy/service/QAService.java",
            "src/main/java/com/aiknowledge/buddy/service/SearchService.java",

            "src/main/java/com/aiknowledge/buddy/client/GitHubClient.java",
            "src/main/java/com/aiknowledge/buddy/client/JiraClient.java",
            "src/main/java/com/aiknowledge/buddy/client/ClaudeClient.java",

            "src/main/resources/application.yml",
            "src/main/resources/application-dev.yml",

            "src/test/",

            "pom.xml",
            ".env",
            "README.md"
        };

        for (String path : structure) {
            File file = new File(basePath + "/" + path);

            try {
                if (path.endsWith("/")) {
                    if (file.mkdirs()) {
                        System.out.println("Created directory: " + file.getPath());
                    }
                } else {
                    File parent = file.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    if (file.createNewFile()) {
                        System.out.println("Created file: " + file.getPath());

                        if (file.getName().endsWith(".java")) {
                            String pkg = getPackageDeclaration(file);
                            try (FileWriter writer = new FileWriter(file)) {
                                writer.write(pkg + "\n\npublic class " + getClassName(file.getName()) + " {\n\n}");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error creating: " + file.getPath());
                e.printStackTrace();
            }
        }
    }

    // Extracts package declaration from file path
    private static String getPackageDeclaration(File file) {
        String path = file.getPath().replace("\\", "/");
        int srcIndex = path.indexOf("src/main/java/");
        if (srcIndex == -1) return ""; // no package
        String packagePath = path.substring(srcIndex + "src/main/java/".length());
        int lastSlash = packagePath.lastIndexOf('/');
        if (lastSlash == -1) return "";
        String packageName = packagePath.substring(0, lastSlash).replace("/", ".");
        return "package " + packageName + ";";
    }

    // Removes .java from file name to get class name
    private static String getClassName(String filename) {
        return filename.replace(".java", "");
    }
}
