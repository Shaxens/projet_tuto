package fr.tradflex.ressource;

import fr.tradflex.dao.ProjectDAO;
import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TestProjectRessource {

    @Mock private ProjectDAO projectDAO;
    @InjectMocks private ProjectRessource projectRessource;

    @BeforeEach
    void setUp() {
        doReturn(null).when(projectDAO).getById("1");
        doReturn(new Project("2", "", "", "", ProjectStatus.TERMINE)).when(projectDAO).getById("2");
    }

    @Test
    void test_getProjet_avec_projet_existant() {
        assertThat(projectRessource.getProject("2")).isEqualTo(new Project("2", "", "", "", ProjectStatus.TERMINE));
    }

    @Test
    void test_getProjet_avec_projet_inexistant() {
        assertThatThrownBy(() -> projectRessource.getProject("1")).isInstanceOf(ProjectRessource.ResourceNotFoundException.class);
    }
}